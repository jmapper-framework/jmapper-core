package it.avutils.jmapper.conversions.explicit;

import static it.avutils.jmapper.util.GeneralUtility.newLine;
import it.avutils.jmapper.annotations.JMapConversion.Type;
import it.avutils.jmapper.bean.ComplexClass;
import it.avutils.jmapper.conversions.explicit.ConversionMethod.ParameterNumber;
import it.avutils.jmapper.enums.ConversionType;
import it.avutils.jmapper.enums.Membership;
import it.avutils.jmapper.operations.AOperation;
import it.avutils.jmapper.operations.complex.ConversionOperation;
import it.avutils.jmapper.operations.info.InfoOperation;

import java.lang.reflect.Field;
import java.util.ArrayList;

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
		ConversionMethod method = new ConversionMethod("conversion", new String[]{"aStringList2"}, new String[]{"aStringList"}, Type.STATIC,ParameterNumber.ONE, "");
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
		
		actual   = operation.write(newInstance).toString();
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
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		expected = "   if(source.getAStringList2()!=null){"+
		 newLine + "   if(destination.getAStringList()!=null){"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
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
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getAStringList()!=null){"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getAStringList()!=null){"+
	     newLine + "   if(source.getAStringList2()==null){"+
	     newLine + "   destination.setAStringList(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getAStringList()==null){"+
		 newLine + "   if(source.getAStringList2()!=null){"+
		 newLine + "   destination.setAStringList(destination.conversion(source.getAStringList2()));"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}	
}
