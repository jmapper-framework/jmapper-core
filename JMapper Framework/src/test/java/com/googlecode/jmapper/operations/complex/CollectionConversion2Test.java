package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.lang.reflect.Field;
import java.util.ArrayList;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

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
		
		expected = "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getASetInteger().toArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer objectOfSource$i = (java.lang.Integer) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.String objectOfDestination$i = objectOfSource$i.toString();"+
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setAListString(collectionOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setAListString(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getAListString()!=null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$z = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getASetInteger().toArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer objectOfSource$i = (java.lang.Integer) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.String objectOfDestination$i = objectOfSource$i.toString();"+
		 newLine + "   collectionOfDestination$z.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getAListString().addAll(collectionOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setAListString(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$z = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$y = source.getASetInteger().toArray();"+
		 newLine + "   for(int index$y = collectionOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.lang.Integer objectOfSource$y = (java.lang.Integer) collectionOfSource$y[index$y];"+
		 newLine + "   java.lang.String objectOfDestination$y = objectOfSource$y.toString();"+
		 newLine + "   collectionOfDestination$z.add(objectOfDestination$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setAListString(collectionOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setAListString(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getASetInteger().toArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer objectOfSource$i = (java.lang.Integer) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.String objectOfDestination$i = objectOfSource$i.toString();"+
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setAListString(collectionOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getASetInteger()!=null){"+
		 newLine + "   if(destination.getAListString()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$z = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getASetInteger().toArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer objectOfSource$i = (java.lang.Integer) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.String objectOfDestination$i = objectOfSource$i.toString();"+
		 newLine + "   collectionOfDestination$z.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getAListString().addAll(collectionOfDestination$z);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   java.util.ArrayList collectionOfDestination$z = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$y = source.getASetInteger().toArray();"+
		 newLine + "   for(int index$y = collectionOfSource$y.length-1;index$y >=0;index$y--){"+
		 newLine + "   java.lang.Integer objectOfSource$y = (java.lang.Integer) collectionOfSource$y[index$y];"+
		 newLine + "   java.lang.String objectOfDestination$y = objectOfSource$y.toString();"+
		 newLine + "   collectionOfDestination$z.add(objectOfDestination$y);"+
		 newLine + "   }"+
		 newLine + "   destination.setAListString(collectionOfDestination$z);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getAListString()!=null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getASetInteger().toArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer objectOfSource$i = (java.lang.Integer) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.String objectOfDestination$i = objectOfSource$i.toString();"+
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getAListString().addAll(collectionOfDestination$i);"+
		 newLine + 
		 newLine + "   }else{"+
		 newLine + "   destination.setAListString(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getAListString()!=null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getASetInteger().toArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer objectOfSource$i = (java.lang.Integer) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.String objectOfDestination$i = objectOfSource$i.toString();"+
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.getAListString().addAll(collectionOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getAListString()!=null){"+
	     newLine + "   if(source.getASetInteger()==null){"+
	     newLine + "   destination.setAListString(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getAListString()==null){"+
		 newLine + "   if(source.getASetInteger()!=null){"+
		 newLine + "   java.util.ArrayList collectionOfDestination$i = new java.util.ArrayList();"+
		 newLine + "   Object[] collectionOfSource$i = source.getASetInteger().toArray();"+
		 newLine + "   for(int index$i = collectionOfSource$i.length-1;index$i >=0;index$i--){"+
		 newLine + "   java.lang.Integer objectOfSource$i = (java.lang.Integer) collectionOfSource$i[index$i];"+
		 newLine + "   java.lang.String objectOfDestination$i = objectOfSource$i.toString();"+
		 newLine + "   collectionOfDestination$i.add(objectOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   destination.setAListString(collectionOfDestination$i);"+
		 newLine + 
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}	
}