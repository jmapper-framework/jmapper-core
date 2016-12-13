package com.googlecode.jmapper.operations.simple;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.simple.BasicOperation;

import com.googlecode.jmapper.bean.SimpleClass;
import com.googlecode.jmapper.operations.AOperation;

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
	protected void allAll() {
		expected = "   destination.setAStringField(Integer.toString(source.getAIntField()));"+newLine;
		write();
		verify();
	}

	@Override
	protected void allValued() {
		expected = "   destination.setAStringField(Integer.toString(source.getAIntField()));"+newLine;
		write();
		verify();
	}

	@Override
	protected void valuedAll() {
		expected = "   if(destination.getAStringField()!=null){"+
		 newLine + "   destination.setAStringField(Integer.toString(source.getAIntField()));"+
	     newLine + "   }"+newLine;
		write();
		verify();	
	}

	@Override
	protected void valuedValued() {
		expected = "   if(destination.getAStringField()!=null){"+
	     newLine + "   destination.setAStringField(Integer.toString(source.getAIntField()));"+
	     newLine + "   }"+newLine;
		write();
		verify();	
	}

	@Override
	protected void valuedNull() {
		expected = newLine;
		write();
		verify();		
	}

	@Override
	protected void nullValued() {
		expected = "   if(destination.getAStringField()==null){"+
		 newLine + "   destination.setAStringField(Integer.toString(source.getAIntField()));"+
		 newLine + "   }"+newLine;
		write();
		verify();		
	}

}
