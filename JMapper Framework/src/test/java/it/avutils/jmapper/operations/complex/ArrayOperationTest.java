package it.avutils.jmapper.operations.complex;

import static it.avutils.jmapper.util.ClassesManager.getFieldValue;
import static it.avutils.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import it.avutils.jmapper.bean.ComplexClass;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.operations.AOperation;
import it.avutils.jmapper.operations.info.InfoOperation;

public class ArrayOperationTest extends AOperation<ArrayOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("StringArray");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("StringArray2");
	}

	@Override
	protected ArrayOperation getOperationIstance() {
		return new ArrayOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.ABSENT);
	}
	
	@Override
	protected void AllAll() {
		
		expected = "   if(source.getStringArray2()!=null){"+
		 newLine + "   destination.setStringArray(source.getStringArray2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(newInstance).toString();
		verify();
		
		Integer i =  getFieldValue(operation,"count");
		
		expected = "   if(destination.getStringArray()!=null){"+
		 newLine + "   if(source.getStringArray2()!=null){"+
		 newLine + "   java.lang.String[] dep"+i+" = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination"+i+" = new java.lang.String[dep"+i+".length + source.getStringArray2().length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = source.getStringArray2().length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = source.getStringArray2()[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setStringArray(newDestination"+i+");"+
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getStringArray2()!=null){"+
		 newLine + "   destination.setStringArray(source.getStringArray2());"+
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getStringArray2()!=null){"+
		 newLine + "   destination.setStringArray(source.getStringArray2());"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getStringArray2()!=null){"+
		 newLine + "   if(destination.getStringArray()!=null){"+
		 newLine + "   java.lang.String[] dep"+i+" = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination"+i+" = new java.lang.String[dep"+i+".length + source.getStringArray2().length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = source.getStringArray2().length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = source.getStringArray2()[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setStringArray(newDestination"+i+");"+
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(source.getStringArray2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void ValuedAll() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getStringArray()!=null){"+
		 newLine + "   if(source.getStringArray2()!=null){"+
		 newLine + "   java.lang.String[] dep"+i+" = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination"+i+" = new java.lang.String[dep"+i+".length + source.getStringArray2().length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = source.getStringArray2().length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = source.getStringArray2()[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setStringArray(newDestination"+i+");"+
		 newLine + "   }else{"+
		 newLine + "   destination.setStringArray(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getStringArray()!=null){"+
		 newLine + "   if(source.getStringArray2()!=null){"+
		 newLine + "   java.lang.String[] dep"+i+" = destination.getStringArray();"+
		 newLine + "   java.lang.String[] newDestination"+i+" = new java.lang.String[dep"+i+".length + source.getStringArray2().length];"+
		 newLine + "   int counter"+i+" = 0;"+
		 newLine + "   for(int index"+i+" = dep"+i+".length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = dep"+i+"[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   for(int index"+i+" = source.getStringArray2().length-1;index"+i+" >=0;index"+i+"--){"+
		 newLine + "   newDestination"+i+"[counter"+i+"++] = source.getStringArray2()[index"+i+"];"+
		 newLine + "   }"+
		 newLine + "   destination.setStringArray(newDestination"+i+");"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getStringArray()!=null){"+
	     newLine + "   if(source.getStringArray2()==null){"+
	     newLine + "   destination.setStringArray(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {
		
		expected = "   if(destination.getStringArray()==null){"+
		 newLine + "   if(source.getStringArray2()!=null){"+
		 newLine + "   destination.setStringArray(source.getStringArray2());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

}
