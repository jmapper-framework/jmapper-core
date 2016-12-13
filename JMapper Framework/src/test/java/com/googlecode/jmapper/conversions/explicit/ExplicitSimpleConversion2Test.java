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

public class ExplicitSimpleConversion2Test extends AOperation<BasicConversion> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aIntField");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return SimpleClass.class.getDeclaredField("aIntField");
	}

	@Override
	protected void setUp() {
		super.setUp();
		ConversionMethod method = new ConversionMethod("conversion", new String[]{"aIntField"}, new String[]{"aIntField"}, Type.STATIC,ParameterNumber.TWO, "",false);
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
	protected void allAll() {
		expected = "   destination.setAIntField(destination.conversion(destination.getAIntField(), source.getAIntField()));"+newLine;
		write();
		verify();
	}

	@Override
	protected void allValued() {
		expected = "   destination.setAIntField(destination.conversion(destination.getAIntField(), source.getAIntField()));"+newLine;
		write();
		verify();
	}

	@Override
	protected void valuedAll() {
		expected = "   destination.setAIntField(destination.conversion(destination.getAIntField(), source.getAIntField()));"+newLine;
		write();
		verify();	
	}

	@Override
	protected void valuedValued() {
		expected = "   destination.setAIntField(destination.conversion(destination.getAIntField(), source.getAIntField()));"+newLine;
		write();
		verify();	
	}

	@Override
	protected void valuedNull() {
		expected = ""+newLine;
		write();
		verify();		
	}

	@Override
	protected void nullValued() {
		expected = ""+newLine;
		write();
		verify();		
	}

}
