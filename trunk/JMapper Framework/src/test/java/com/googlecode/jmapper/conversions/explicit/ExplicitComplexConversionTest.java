package com.googlecode.jmapper.conversions.explicit;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.googlecode.jmapper.annotations.JMapConversion.Type;
import com.googlecode.jmapper.conversions.explicit.ConversionMethod;
import com.googlecode.jmapper.conversions.explicit.ConversionMethod.ParameterNumber;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.enums.Membership;
import com.googlecode.jmapper.operations.complex.ConversionOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class ExplicitComplexConversionTest extends AOperation<ConversionOperation> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aStringList");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aStringList2");
	}

	@Override
	protected ConversionOperation getOperationIstance() {
		return new ConversionOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.ABSENT);
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		try { operation.setDestinationClass(ArrayList.class);
		ConversionMethod method = new ConversionMethod("conversion", new String[]{"aStringList2"}, new String[]{"aStringList"}, Type.STATIC,ParameterNumber.ONE, "",true);
			  operation.setConversionMethod(method)
			           .setMemberShip(Membership.DESTINATION);
		} catch (Exception e) {}
	}
	
	@Override
	protected void AllAll() {
		
		expected = "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getAStringList()!=null){"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getAStringList2()!=null){"+
		 newLine + "   if(destination.getAStringList()!=null){"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getAStringList()!=null){"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getAStringList()!=null){"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getAStringList()!=null){"+
	     newLine + "   if(source.getAStringList2()==null){"+
	     newLine + "   destination.setAStringList(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getAStringList()==null){"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}	
}
