package com.googlecode.jmapper.operations.simple;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.simple.BasicOperation;

import com.googlecode.jmapper.bean.SimpleClass;
import com.googlecode.jmapper.operations.AOperation;

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
	protected void allAll() {
		expected = "   destination.setAField(source.getAField());"+newLine;
		write();
		verify();
	}

	@Override
	protected void allValued() {
		expected = "   if(source.getAField()!=null){"+
		 newLine + "   destination.setAField(source.getAField());"+
		 newLine + "   }"+newLine;
		write();
		verify();
	}

	@Override
	protected void valuedAll() {
		expected = "   if(destination.getAField()!=null){"+
		 newLine + "   destination.setAField(source.getAField());"+
	     newLine + "   }"+newLine;
		write();
		verify();	
	}

	@Override
	protected void valuedValued() {
		expected = "   if(destination.getAField()!=null){"+
	     newLine + "   if(source.getAField()!=null){"+
	     newLine + "   destination.setAField(source.getAField());"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		write();
		verify();	
	}

	@Override
	protected void valuedNull() {
		expected = "   if(destination.getAField()!=null){"+
	     newLine + "   if(source.getAField()==null){"+
	     newLine + "   destination.setAField(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		write();
		verify();		
	}

	@Override
	protected void nullValued() {
		expected = "   if(destination.getAField()==null){"+
		 newLine + "   if(source.getAField()!=null){"+
		 newLine + "   destination.setAField(source.getAField());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		write();
		verify();		
	}

}
