package it.avutils.jmapper.conversions.explicit;

import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.annotations.JMapConversion.Type;
import it.avutils.jmapper.bean.SimpleClass;
import it.avutils.jmapper.conversions.explicit.ConversionMethod.ParameterNumber;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.enums.Membership;
import it.avutils.jmapper.operations.AOperation;
import it.avutils.jmapper.operations.info.InfoOperation;
import it.avutils.jmapper.operations.simple.BasicConversion;

import java.lang.reflect.Field;

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
		actual   = operation.write().toString();
		verify();
	}

	@Override
	protected void AllValued() {
		expected = "   if(source.getAField()!=null){"+
		 newLine + "   destination.setAField(destination.conversion(source.getAField()));"+
		 newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		expected = "   if(destination.getAField()!=null){"+
		 newLine + "   destination.setAField(destination.conversion(source.getAField()));"+
	     newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {
		expected = "   if(destination.getAField()!=null){"+
	     newLine + "   if(source.getAField()!=null){"+
	     newLine + "   destination.setAField(destination.conversion(source.getAField()));"+
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
		 newLine + "   destination.setAField(destination.conversion(source.getAField()));"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		actual	 = operation.write().toString();
		verify();		
	}

}
