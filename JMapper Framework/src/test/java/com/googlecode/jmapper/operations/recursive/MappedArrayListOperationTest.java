package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;

import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class MappedArrayListOperationTest extends
		AOperation<MappedArrayListOperation> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aMappedArray");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aTargetList");
	}

	@Override
	protected MappedArrayListOperation getOperationIstance() {
		return new MappedArrayListOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation();
	}
	
	@Override
	protected void AllAll() {
		
		expected = "   if(source.getATargetList()!=null){"+
		newLine + "   Object[] arrayListOfSource$i = source.getATargetList().toArray();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayListOfDestination$i = new com.googlecode.jmapper.bean.MappedObject[arrayListOfSource$i.length];"+
		newLine + "   for(int index$i = arrayListOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfSoure$i = (com.googlecode.jmapper.bean.TargetObject) arrayListOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfDestination$i = null;" +
		newLine + "   if(super.getDestinationFactory()!=null){" +
		newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		newLine + "   }else{" +
		newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.MappedObject();" +
		newLine + "   }" + 
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + 
		newLine + "   arrayListOfDestination$i[index$i] = objectOfDestination$i;"+
		newLine + "   }"+
		newLine + "   destination.setAMappedArray(arrayListOfDestination$i);"+
		newLine + 
		newLine + "   }else{"+
		newLine + "   destination.setAMappedArray(null);"+
		newLine + "   }"+newLine;
				
				write(newInstance);
				verify();

		expected = "   if(destination.getAMappedArray()!=null){"+
		 newLine + "   if(source.getATargetList()!=null){"+
		 newLine + "   Object[] arrayListOfSource$i = source.getATargetList().toArray();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayListOfDestination$z = new com.googlecode.jmapper.bean.MappedObject[arrayListOfSource$i.length];"+
		 newLine + "   for(int index$i = arrayListOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfSoure$i = (com.googlecode.jmapper.bean.TargetObject) arrayListOfSource$i[index$i];"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfDestination$i = null;" +
			newLine + "   if(super.getDestinationFactory()!=null){" +
			newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
			newLine + "   }else{" +
			newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.MappedObject();" +
			newLine + "   }" + 
			newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		 newLine + 
		 newLine + "   arrayListOfDestination$z[index$i] = objectOfDestination$i;"+
		 newLine + "   }"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] dep$i = destination.getAMappedArray();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] newDestination$i = (com.googlecode.jmapper.bean.MappedObject[]) java.util.Arrays.copyOf(dep$i, dep$i.length + arrayListOfDestination$z.length);"+
		 newLine + "   System.arraycopy(arrayListOfDestination$z, 0, newDestination$i, dep$i.length, arrayListOfDestination$z.length);"+
		 newLine + "   destination.setAMappedArray(newDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setAMappedArray(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getATargetList()!=null){"+
		 newLine + "   Object[] arrayListOfSource$y = source.getATargetList().toArray();"+
		 newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayListOfDestination$z = new com.googlecode.jmapper.bean.MappedObject[arrayListOfSource$y.length];"+
		 newLine + "   for(int index$y = arrayListOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfSoure$y = (com.googlecode.jmapper.bean.TargetObject) arrayListOfSource$y[index$y];"+
		 
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfDestination$y = null;" +
		newLine + "   if(super.getDestinationFactory()!=null){" +
		newLine + "   objectOfDestination$y = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		newLine + "   }else{" +
		newLine + "   objectOfDestination$y = new com.googlecode.jmapper.bean.MappedObject();" +
		newLine + "   }" + 

		 
		 newLine + "   objectOfDestination$y.setField(objectOfSoure$y.getField());"+
		 newLine + 
		 newLine + "   arrayListOfDestination$z[index$y] = objectOfDestination$y;"+
		 newLine + "   }"+
		 newLine + "   destination.setAMappedArray(arrayListOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setAMappedArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
				write(enrichment);
				verify();
	}

	@Override
	protected void AllValued() {
		expected = "   if(source.getATargetList()!=null){"+
		newLine + "   Object[] arrayListOfSource$i = source.getATargetList().toArray();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayListOfDestination$i = new com.googlecode.jmapper.bean.MappedObject[arrayListOfSource$i.length];"+
		newLine + "   for(int index$i = arrayListOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfSoure$i = (com.googlecode.jmapper.bean.TargetObject) arrayListOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfDestination$i = null;" +
		newLine + "   if(super.getDestinationFactory()!=null){" +
		newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		newLine + "   }else{" +
		newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.MappedObject();" +
		newLine + "   }" + 
		newLine + "   if(objectOfSoure$i.getField()!=null){"+
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + "   }"+
		newLine + 
		newLine + "   arrayListOfDestination$i[index$i] = objectOfDestination$i;"+
		newLine + "   }"+
		newLine + "   destination.setAMappedArray(arrayListOfDestination$i);"+
		newLine + 
		newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getATargetList()!=null){"+
		newLine + "   if(destination.getAMappedArray()!=null){"+
		newLine + "   Object[] arrayListOfSource$i = source.getATargetList().toArray();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayListOfDestination$z = new com.googlecode.jmapper.bean.MappedObject[arrayListOfSource$i.length];"+
		newLine + "   for(int index$i = arrayListOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfSoure$i = (com.googlecode.jmapper.bean.TargetObject) arrayListOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfDestination$i = null;" +
		newLine + "   if(super.getDestinationFactory()!=null){" +
		newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		newLine + "   }else{" +
		newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.MappedObject();" +
		newLine + "   }" + 
		newLine + "   if(objectOfSoure$i.getField()!=null){"+
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + "   }"+
		newLine + 
		newLine + "   arrayListOfDestination$z[index$i] = objectOfDestination$i;"+
		newLine + "   }"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] dep$i = destination.getAMappedArray();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] newDestination$i = (com.googlecode.jmapper.bean.MappedObject[]) java.util.Arrays.copyOf(dep$i, dep$i.length + arrayListOfDestination$z.length);"+
		newLine + "   System.arraycopy(arrayListOfDestination$z, 0, newDestination$i, dep$i.length, arrayListOfDestination$z.length);"+
		newLine + "   destination.setAMappedArray(newDestination$i);"+
		newLine + 
		newLine + "   }else{"+
		newLine + "   Object[] arrayListOfSource$y = source.getATargetList().toArray();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayListOfDestination$z = new com.googlecode.jmapper.bean.MappedObject[arrayListOfSource$y.length];"+
		newLine + "   for(int index$y = arrayListOfSource$y.length-1;index$y >=0;index$y--){"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfSoure$y = (com.googlecode.jmapper.bean.TargetObject) arrayListOfSource$y[index$y];"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfDestination$y = null;" +
		newLine + "   if(super.getDestinationFactory()!=null){" +
		newLine + "   objectOfDestination$y = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		newLine + "   }else{" +
		newLine + "   objectOfDestination$y = new com.googlecode.jmapper.bean.MappedObject();" +
		newLine + "   }" + 
		newLine + "   if(objectOfSoure$y.getField()!=null){"+
		newLine + "   objectOfDestination$y.setField(objectOfSoure$y.getField());"+
		newLine + "   }"+
		newLine + 
		newLine + "   arrayListOfDestination$z[index$y] = objectOfDestination$y;"+
		newLine + "   }"+
		newLine + "   destination.setAMappedArray(arrayListOfDestination$z);"+
		newLine + 
		newLine + "   }"+
		newLine + "   }"+newLine;
		write(enrichment);
		verify();
		
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getAMappedArray()!=null){"+
		newLine + "   if(source.getATargetList()!=null){"+
		newLine + "   Object[] arrayListOfSource$i = source.getATargetList().toArray();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayListOfDestination$i = new com.googlecode.jmapper.bean.MappedObject[arrayListOfSource$i.length];"+
		newLine + "   for(int index$i = arrayListOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfSoure$i = (com.googlecode.jmapper.bean.TargetObject) arrayListOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfDestination$i = null;" +
		newLine + "   if(super.getDestinationFactory()!=null){" +
		newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		newLine + "   }else{" +
		newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.MappedObject();" +
		newLine + "   }" + 
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + 
		newLine + "   arrayListOfDestination$i[index$i] = objectOfDestination$i;"+
		newLine + "   }"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] dep$i = destination.getAMappedArray();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] newDestination$i = (com.googlecode.jmapper.bean.MappedObject[]) java.util.Arrays.copyOf(dep$i, dep$i.length + arrayListOfDestination$i.length);"+
		newLine + "   System.arraycopy(arrayListOfDestination$i, 0, newDestination$i, dep$i.length, arrayListOfDestination$i.length);"+
		newLine + "   destination.setAMappedArray(newDestination$i);"+
		newLine + 
		newLine + "   }else{"+
		newLine + "   destination.setAMappedArray(null);"+
		newLine + "   }"+
		newLine + "   }"+newLine;
		write(enrichment);
		verify();
	
	}

	@Override
	protected void ValuedValued() {
		
		expected = "   if(destination.getAMappedArray()!=null){"+
		newLine + "   if(source.getATargetList()!=null){"+
		newLine + "   Object[] arrayListOfSource$i = source.getATargetList().toArray();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayListOfDestination$i = new com.googlecode.jmapper.bean.MappedObject[arrayListOfSource$i.length];"+
		newLine + "   for(int index$i = arrayListOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfSoure$i = (com.googlecode.jmapper.bean.TargetObject) arrayListOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfDestination$i = null;" +
		newLine + "   if(super.getDestinationFactory()!=null){" +
		newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		newLine + "   }else{" +
		newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.MappedObject();" +
		newLine + "   }" + 
		newLine + "   if(objectOfSoure$i.getField()!=null){"+
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + "   }"+
		newLine + 
		newLine + "   arrayListOfDestination$i[index$i] = objectOfDestination$i;"+
		newLine + "   }"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] dep$i = destination.getAMappedArray();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] newDestination$i = (com.googlecode.jmapper.bean.MappedObject[]) java.util.Arrays.copyOf(dep$i, dep$i.length + arrayListOfDestination$i.length);"+
		newLine + "   System.arraycopy(arrayListOfDestination$i, 0, newDestination$i, dep$i.length, arrayListOfDestination$i.length);"+
		newLine + "   destination.setAMappedArray(newDestination$i);"+
		newLine +
		newLine + "   }"+
		newLine + "   }"+newLine;
		write(enrichment);
		verify();
		
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getAMappedArray()!=null){"+
		newLine + "   if(source.getATargetList()==null){"+
		newLine + "   destination.setAMappedArray(null);"+
		newLine + "   }"+
		newLine + "   }"+newLine;
		write(enrichment);
		verify();
		
	}

	@Override
	protected void NullValued() {
		
		expected = "   if(destination.getAMappedArray()==null){"+
		newLine + "   if(source.getATargetList()!=null){"+
		newLine + "   Object[] arrayListOfSource$i = source.getATargetList().toArray();"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject[] arrayListOfDestination$i = new com.googlecode.jmapper.bean.MappedObject[arrayListOfSource$i.length];"+
		newLine + "   for(int index$i = arrayListOfSource$i.length-1;index$i >=0;index$i--){"+
		newLine + "   com.googlecode.jmapper.bean.TargetObject objectOfSoure$i = (com.googlecode.jmapper.bean.TargetObject) arrayListOfSource$i[index$i];"+
		newLine + "   com.googlecode.jmapper.bean.MappedObject objectOfDestination$i = null;" +
		newLine + "   if(super.getDestinationFactory()!=null){" +
		newLine + "   objectOfDestination$i = (com.googlecode.jmapper.bean.MappedObject) super.getDestinationFactory().make();" +
		newLine + "   }else{" +
		newLine + "   objectOfDestination$i = new com.googlecode.jmapper.bean.MappedObject();" +
		newLine + "   }" + 
		newLine + "   if(objectOfSoure$i.getField()!=null){"+
		newLine + "   objectOfDestination$i.setField(objectOfSoure$i.getField());"+
		newLine + "   }"+
		newLine + 
		newLine + "   arrayListOfDestination$i[index$i] = objectOfDestination$i;"+
		newLine + "   }"+
		newLine + "   destination.setAMappedArray(arrayListOfDestination$i);"+
		newLine + 
		newLine + "   }"+
		newLine + "   }"+newLine;
		write(enrichment);
		verify();
		
	}
}
