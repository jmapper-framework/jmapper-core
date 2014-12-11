package com.googlecode.jmapper.operations;

import static com.googlecode.jmapper.util.ClassesManager.getFieldValue;
import static com.googlecode.jmapper.util.GeneralUtility.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.googlecode.jmapper.enums.MappingType;
import com.googlecode.jmapper.operations.beans.MappedField;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.recursive.ARecursiveOperation;
import com.googlecode.jmapper.util.GeneralUtility;
import com.googlecode.jmapper.xml.XML;

public abstract class AOperation<T extends AGeneralOperation> extends TestCase {

	/** used for identify new instance operation */
	protected boolean newInstance = true;
	
	/** used for identify enrichment operation */
	protected boolean enrichment = false;
	
	/** operation that will be used */
	protected T operation;
	
	/** expected mapping */
	protected String expected;
	
	/** actual mapping */
	protected String actual;
	
	/** value of count field */
	protected Integer i;
	
	/** @return returns the destination field 
	 * @throws NoSuchFieldException */
	protected abstract Field getDField() throws NoSuchFieldException;
	
	/** @return returns the source field */
	protected abstract Field getSField() throws NoSuchFieldException;
	
	/** @return returns the operation istance */
	protected abstract T getOperationIstance();
	
	/** @return returns the operation istance */
	protected abstract InfoOperation getInfoOperation();
	
	@Override
	protected void setUp(){
		operation = getOperationIstance();
		try{
			MappedField dField = new MappedField(getDField());
			dField.getMethod(getMethod(dField.getType(), dField.getName()));
			dField.setMethod(mSet(dField.getName()));
			
			MappedField sField = new MappedField(getSField());
			sField.getMethod(getMethod(sField.getType(), sField.getName()));
			
			    operation.setDestinationField(dField);
				operation.setSourceField(sField);
		}catch(Exception e){}
		operation.initialDGetPath("destination");
		operation.initialDSetPath("destination");
		operation.initialSGetPath("source");
		operation.setInfoOperation(getInfoOperation());
		if(operation instanceof ARecursiveOperation)
			((ARecursiveOperation)operation).setXml(new XML());
		
	}
	
	/** method to be implemented to test the AllAll combination */
	protected abstract void AllAll();
	
	/** method to be implemented to test the AllValued combination */
	protected abstract void AllValued();
	
	/** method to be implemented to test the ValuedAll combination */
	protected abstract void ValuedAll();
	
	/** method to be implemented to test the ValuedValued combination */
	protected abstract void ValuedValued();
	
	/** method to be implemented to test the ValuedNull combination */
	protected abstract void ValuedNull();
	
	/** method to be implemented to test the NullValued combination */
	protected abstract void NullValued();
	
	public void verify(){
		assertEquals(replace$(expected,"i",""+(i),"y",""+(++i)), actual);
	}
	
	public void testAllAll(){
		operation.setMtd(MappingType.ALL_FIELDS)
	    		 .setMts(MappingType.ALL_FIELDS);
	
		AllAll();
	}
	
	public void testAllValued(){
		operation.setMtd(MappingType.ALL_FIELDS)
		 		 .setMts(MappingType.ONLY_VALUED_FIELDS);
	
		AllValued();
	}
	
	public void testValuedAll(){
		operation.setMtd(MappingType.ONLY_VALUED_FIELDS)
		 		 .setMts(MappingType.ALL_FIELDS);

		ValuedAll();
	}
	
	public void testValuedValued(){
		operation.setMtd(MappingType.ONLY_VALUED_FIELDS)
		 		 .setMts(MappingType.ONLY_VALUED_FIELDS);

		ValuedValued();
	}
	
	public void testValuedNull(){
		operation.setMtd(MappingType.ONLY_VALUED_FIELDS)
		 		 .setMts(MappingType.ONLY_NULL_FIELDS);
		
		ValuedNull();
	}
	
	public void testNullValued(){
		operation.setMtd(MappingType.ONLY_NULL_FIELDS)
		 		 .setMts(MappingType.ONLY_VALUED_FIELDS);

		NullValued();
	}
	
	/**
	 * Replaces the variables present in the text and returns the result.<br>
	 * Each key will be added to the $ prefix.
	 * @param text text to edit
	 * @param pairs strings in "key","value","key","value" order
	 * @return the text resultant
	 */
	protected static String replace$ (String text, String... pairs){
		String key = null;
		String value = null;
		Map<String, String> vars = new HashMap<String, String>();
		for(int i = 0; i < pairs.length; i++){
			
			if(i%2 == 0) key = pairs[i];
			
			if(i%2 == 1){
				value = pairs[i];
				vars.put(key, value);
			}
		}
		return GeneralUtility.replace$(text, vars);
	}
	
	public void write(){
		i =  0;
		try {Method method = operation.getClass().getMethod("write",new Class[]{});
		     actual = ((StringBuilder) method.invoke(operation, new Object[]{})).toString();
		} catch (Exception e) {e.printStackTrace();}
	}
	
	public void write(boolean type){
		i =  (Integer) getFieldValue(operation,"count");
		if(i == null) i = 0;
		try {Method method = operation.getClass().getMethod("write",boolean.class);
		     actual = ((StringBuilder) method.invoke(operation, type)).toString();
		} catch (Exception e) {e.printStackTrace();}
	}
	
	
}
