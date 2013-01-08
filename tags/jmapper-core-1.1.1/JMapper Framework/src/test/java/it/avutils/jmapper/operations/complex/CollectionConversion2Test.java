package it.avutils.jmapper.operations.complex;

import static it.avutils.jmapper.util.ClassesManager.getFieldValue;
import static it.avutils.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import it.avutils.jmapper.bean.ComplexClass;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.operations.AOperation;
import it.avutils.jmapper.operations.info.InfoOperation;

import java.util.ArrayList;

public class CollectionConversion2Test extends AOperation<CollectionOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aListString");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aSetInteger");
	}

	@Override
	protected CollectionOperation getOperationIstance() {
		return new CollectionOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.FromIntegerToString);
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		operation.setDestinationClass(ArrayList.class);
	}
	
	@Override
	protected void AllAll() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getASetInteger().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.Integer objectOfSource"+i+" = (java.lang.Integer) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.String objectOfDestination"+i+" = objectOfSource"+i+".toString();"+
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setAListString(collectionOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setAListString(null);"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getAListString()!=null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getASetInteger().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.Integer objectOfSource"+i+" = (java.lang.Integer) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.String objectOfDestination"+i+" = objectOfSource"+i+".toString();"+
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getAListString().addAll(collectionOfDestination"+i+++");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setAListString(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getASetInteger().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.Integer objectOfSource"+i+" = (java.lang.Integer) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.String objectOfDestination"+i+" = objectOfSource"+i+".toString();"+
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setAListString(collectionOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setAListString(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getASetInteger().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.Integer objectOfSource"+i+" = (java.lang.Integer) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.String objectOfDestination"+i+" = objectOfSource"+i+".toString();"+
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setAListString(collectionOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getASetInteger()!=null){"+
		 newLine + "   if(destination.getAListString()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getASetInteger().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.Integer objectOfSource"+i+" = (java.lang.Integer) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.String objectOfDestination"+i+" = objectOfSource"+i+".toString();"+
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getAListString().addAll(collectionOfDestination"+i+++");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getASetInteger().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.Integer objectOfSource"+i+" = (java.lang.Integer) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.String objectOfDestination"+i+" = objectOfSource"+i+".toString();"+
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setAListString(collectionOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getAListString()!=null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getASetInteger().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.Integer objectOfSource"+i+" = (java.lang.Integer) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.String objectOfDestination"+i+" = objectOfSource"+i+".toString();"+
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getAListString().addAll(collectionOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setAListString(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getAListString()!=null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getASetInteger().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.Integer objectOfSource"+i+" = (java.lang.Integer) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.String objectOfDestination"+i+" = objectOfSource"+i+".toString();"+
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.getAListString().addAll(collectionOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getAListString()!=null){"+
	     newLine + "   if(source.getASetInteger()==null){"+
	     newLine + "   destination.setAListString(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getAListString()==null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination"+i+" = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource"+i+" = source.getASetInteger().toArray();"+
		 newLine + "   for(int index"+i+" = collectionOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   java.lang.Integer objectOfSource"+i+" = (java.lang.Integer) collectionOfSource"+i+"[index"+i+"];"+
		 newLine + "   java.lang.String objectOfDestination"+i+" = objectOfSource"+i+".toString();"+
		 newLine + "   collectionOfDestination"+i+".add(objectOfDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   destination.setAListString(collectionOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}	
}