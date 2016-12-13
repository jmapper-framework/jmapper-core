package com.googlecode.jmapper.operations.simple;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;

import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.simple.BasicOperation;

import com.googlecode.jmapper.bean.SimpleClass;
import com.googlecode.jmapper.operations.AOperation;

public class BasicConversion3Test extends AOperation<BasicOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aStringField");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aIntegerField");
	}

	@Override
	protected BasicOperation getOperationIstance() {
		return new BasicOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.FromIntegerToString);
	}
	
	@Override
	protected void allAll() {
		expected = "   destination.setAStringField(source.getAIntegerField().toString());"+newLine;
		write();
		verify();
	}

	@Override
	protected void allValued() {
		expected = "   if(source.getAIntegerField()!=null){"+
		 newLine + "   destination.setAStringField(source.getAIntegerField().toString());"+
		 newLine + "   }"+newLine;
		write();
		verify();
	}

	@Override
	protected void valuedAll() {
		expected = "   if(destination.getAStringField()!=null){"+
		 newLine + "   destination.setAStringField(source.getAIntegerField().toString());"+
	     newLine + "   }"+newLine;
		write();
		verify();	
	}

	@Override
	protected void valuedValued() {
		expected = "   if(destination.getAStringField()!=null){"+
	     newLine + "   if(source.getAIntegerField()!=null){"+
	     newLine + "   destination.setAStringField(source.getAIntegerField().toString());"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		write();
		verify();	
	}

	@Override
	protected void valuedNull() {
		expected = "   if(destination.getAStringField()!=null){"+
	     newLine + "   if(source.getAIntegerField()==null){"+
	     newLine + "   destination.setAStringField(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		write();
		verify();		
	}

	@Override
	protected void nullValued() {
		expected = "   if(destination.getAStringField()==null){"+
		 newLine + "   if(source.getAIntegerField()!=null){"+
		 newLine + "   destination.setAStringField(source.getAIntegerField().toString());"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		write();
		verify();		
	}

}
