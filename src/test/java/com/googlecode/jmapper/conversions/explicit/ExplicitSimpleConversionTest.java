package com.googlecode.jmapper.conversions.explicit;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import com.googlecode.jmapper.bean.SimpleClass;
import com.googlecode.jmapper.operations.AOperation;

import java.lang.reflect.Field;

import com.googlecode.jmapper.annotations.JMapConversion.Type;
import com.googlecode.jmapper.conversions.explicit.ConversionMethod;
import com.googlecode.jmapper.conversions.explicit.ConversionMethod.ParameterNumber;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.enums.Membership;
import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.simple.BasicConversion;

public class ExplicitSimpleConversionTest extends AOperation<BasicConversion> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aField");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aField");
	}

	@Override
	protected void setUp() {
		super.setUp();
		ConversionMethod method = new ConversionMethod("conversion", new String[]{"field"}, new String[]{"field"}, Type.STATIC,ParameterNumber.ONE, "");
		try{ operation.setConversionMethod(method)
                      .setMemberShip(Membership.DESTINATION);
		}catch(Exception e){}
		
	}
	@Override
	protected BasicConversion getOperationIstance() {
		return new BasicConversion();
	}

	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.ABSENT);
	}
	
	@Override
	protected void AllAll() {
		expected = "   destination.setAField(destination.conversion(source.getAField()));"+newLine;
		write();
		verify();
	}

	@Override
	protected void AllValued() {
		expected = "   if(source.getAField()!=null){"+
		 newLine + "   destination.setAField(destination.conversion(source.getAField()));"+
		 newLine + "   }"+newLine;
		write();
		verify();
	}

	@Override
	protected void ValuedAll() {
		expected = "   if(destination.getAField()!=null){"+
		 newLine + "   destination.setAField(destination.conversion(source.getAField()));"+
	     newLine + "   }"+newLine;
		write();
		verify();	
	}

	@Override
	protected void ValuedValued() {
		expected = "   if(destination.getAField()!=null){"+
	     newLine + "   if(source.getAField()!=null){"+
	     newLine + "   destination.setAField(destination.conversion(source.getAField()));"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		write();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		expected = "   if(destination.getAField()!=null){"+
	     newLine + "   if(source.getAField()==null){"+
	     newLine + "   destination.setAField(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		write();
		verify();		
	}

	@Override
	protected void NullValued() {
		expected = "   if(destination.getAField()==null){"+
		 newLine + "   if(source.getAField()!=null){"+
		 newLine + "   destination.setAField(destination.conversion(source.getAField()));"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		write();
		verify();		
	}

}
