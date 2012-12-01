package it.avutils.jmapper.operations.simple;

import static it.avutils.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import it.avutils.jmapper.bean.SimpleClass;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.operations.AOperation;
import it.avutils.jmapper.operations.info.InfoOperation;

public class BasicConversion4Test extends AOperation<BasicOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aStringField");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aIntField");
	}

	@Override
	protected BasicOperation getOperationIstance() {
		return new BasicOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.FromintToString);
	}
	
	@Override
	protected void AllAll() {
		expected = "   destination.setAStringField(Integer.toString(source.getAIntField()));"+newLine;
		actual   = operation.write().toString();
		verify();
	}

	@Override
	protected void AllValued() {
		expected = "   destination.setAStringField(Integer.toString(source.getAIntField()));"+newLine;
		actual	 = operation.write().toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		expected = "   if(destination.getAStringField()!=null){"+
		 newLine + "   destination.setAStringField(Integer.toString(source.getAIntField()));"+
	     newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {
		expected = "   if(destination.getAStringField()!=null){"+
	     newLine + "   destination.setAStringField(Integer.toString(source.getAIntField()));"+
	     newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		expected = newLine;
		actual	 = operation.write().toString();
		verify();		
	}

	@Override
	protected void NullValued() {
		expected = "   if(destination.getAStringField()==null){"+
		 newLine + "   destination.setAStringField(Integer.toString(source.getAIntField()));"+
		 newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();		
	}

}
