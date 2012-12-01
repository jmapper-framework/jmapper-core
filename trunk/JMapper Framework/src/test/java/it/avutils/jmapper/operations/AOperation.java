package it.avutils.jmapper.operations;

import it.avutils.jmapper.enums.MappingType;
import it.avutils.jmapper.operations.info.InfoOperation;
import it.avutils.jmapper.operations.recursive.ARecursiveOperation;
import it.avutils.jmapper.util.XML;
import java.lang.reflect.Field;
import junit.framework.TestCase;

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
		try{	operation.setDestinationField(getDField());
				operation.setSourceField(getSField());
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
		assertEquals(expected, actual);
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
}
