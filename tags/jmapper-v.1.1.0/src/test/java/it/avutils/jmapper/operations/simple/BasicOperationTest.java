package it.avutils.jmapper.operations.simple;

import static it.avutils.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;

import it.avutils.jmapper.bean.SimpleClass;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.operations.AOperation;
import it.avutils.jmapper.operations.info.InfoOperation;

public class BasicOperationTest extends AOperation<BasicOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aField");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aField");
	}

	@Override
	protected BasicOperation getOperationIstance() {
		return new BasicOperation();
	}

	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.ABSENT);
	}
	
	@Override
	protected void AllAll() {
		expected = "   destination.setAField(source.getAField());"+newLine;
		actual   = operation.write().toString();
		verify();
	}

	@Override
	protected void AllValued() {
		expected = "   if(source.getAField()!=null){"+
		 newLine + "   destination.setAField(source.getAField());"+
		 newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		expected = "   if(destination.getAField()!=null){"+
		 newLine + "   destination.setAField(source.getAField());"+
	     newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {
		expected = "   if(destination.getAField()!=null){"+
	     newLine + "   if(source.getAField()!=null){"+
	     newLine + "   destination.setAField(source.getAField());"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		expected = "   if(destination.getAField()!=null){"+
	     newLine + "   if(source.getAField()==null){"+
	     newLine + "   destination.setAField(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();		
	}

	@Override
	protected void NullValued() {
		expected = "   if(destination.getAField()==null){"+
		 newLine + "   if(source.getAField()!=null){"+
		 newLine + "   destination.setAField(source.getAField());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();		
	}

}
