package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.util.ClassesManager.getFieldValue;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;

import java.lang.reflect.Field;

import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.recursive.MappedArrayOperation;

public class MappedArrayOperationTest extends AOperation<MappedArrayOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aTargetArray");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aMappedArray");
	}

	@Override
	protected MappedArrayOperation getOperationIstance() {
		return new MappedArrayOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation();
	}
	
	@Override
	protected void AllAll() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource"+i+" = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine +
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(arrayOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetArray(null);"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getATargetArray()!=null){"+
		 newLine + "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource"+i+" = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine +
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] dep"+i+" = destination.getATargetArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] newDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[dep"+i+".length + arrayOfDestination"+i+".length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = arrayOfDestination"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = arrayOfDestination"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(newDestination"+i+++");"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetArray(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource"+i+" = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine +
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(arrayOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource"+i+" = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure"+i+".getField()!=null){"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(arrayOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getAMappedArray()!=null){"+
		 newLine + "   if(destination.getATargetArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource"+i+" = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure"+i+".getField()!=null){"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] dep"+i+" = destination.getATargetArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] newDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[dep"+i+".length + arrayOfDestination"+i+".length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = arrayOfDestination"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = arrayOfDestination"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(newDestination"+i+++");"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource"+i+" = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure"+i+".getField()!=null){"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(arrayOfDestination"+i+");"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void ValuedAll() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getATargetArray()!=null){"+
		 newLine + "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource"+i+" = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine +
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] dep"+i+" = destination.getATargetArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] newDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[dep"+i+".length + arrayOfDestination"+i+".length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = arrayOfDestination"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = arrayOfDestination"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(newDestination"+i+++");"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setATargetArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getATargetArray()!=null){"+
		 newLine + "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource"+i+" = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure"+i+".getField()!=null){"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] dep"+i+" = destination.getATargetArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] newDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[dep"+i+".length + arrayOfDestination"+i+".length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = arrayOfDestination"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = arrayOfDestination"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(newDestination"+i+++");"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getATargetArray()!=null){"+
	     newLine + "   if(source.getAMappedArray()==null){"+
	     newLine + "   destination.setATargetArray(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getATargetArray()==null){"+
		 newLine + "   if(source.getAMappedArray()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayOfSource"+i+" = source.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject[] arrayOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject[arrayOfSource"+i+".length];"+
		 newLine + "   for(int index"+i+" = arrayOfSource"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfSoure"+i+" = (com.googlecode.jmapper.bean.MappedObject) arrayOfSource"+i+"[index"+i+"];"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfDestination"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   if(objectOfSoure"+i+".getField()!=null){"+
		 newLine + "   objectOfDestination"+i+".setField(objectOfSoure"+i+".getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   arrayOfDestination"+i+"[index"+i+"] = objectOfDestination"+i+";"+
		 newLine + "   }"+
		 newLine + "   destination.setATargetArray(arrayOfDestination"+i+");"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

}
