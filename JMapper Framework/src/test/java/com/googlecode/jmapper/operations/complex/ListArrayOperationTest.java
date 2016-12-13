package com.googlecode.jmapper.operations.complex;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;
import java.util.ArrayList;

import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class ListArrayOperationTest extends AOperation<ListArrayOperation> {

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("aStringList");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("StringArray");
	}

	@Override
	protected ListArrayOperation getOperationIstance() {
		return new ListArrayOperation();
	}

	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation().setConversionType(ConversionType.ABSENT);
	}

	@Override
	protected void setUp() {
		super.setUp();
		operation.setDestinationClass(ArrayList.class);
	}
	
	@Override
	protected void allAll() {
		
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList(java.util.Arrays#asList(source.getStringArray()));"+
		 newLine + "   destination.setAStringList(listArrayOfDestination$i);"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();

		expected = "   if(destination.getAStringList()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$z = new java.util.ArrayList(java.util.Arrays#asList(source.getStringArray()));"+
		 newLine + "   destination.getAStringList().addAll(listArrayOfDestination$z);"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$z = new java.util.ArrayList(java.util.Arrays#asList(source.getStringArray()));"+
		 newLine + "   destination.setAStringList(listArrayOfDestination$z);"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void allValued() {
		
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList(java.util.Arrays#asList(source.getStringArray()));"+
		 newLine + "   destination.setAStringList(listArrayOfDestination$i);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getStringArray()!=null){"+
		 newLine + "   if(destination.getAStringList()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$z = new java.util.ArrayList(java.util.Arrays#asList(source.getStringArray()));"+
		 newLine + "   destination.getAStringList().addAll(listArrayOfDestination$z);"+
		 newLine + "   }else{"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$z = new java.util.ArrayList(java.util.Arrays#asList(source.getStringArray()));"+
		 newLine + "   destination.setAStringList(listArrayOfDestination$z);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void valuedAll() {
		
		expected = "   if(destination.getAStringList()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList(java.util.Arrays#asList(source.getStringArray()));"+
		 newLine + "   destination.getAStringList().addAll(listArrayOfDestination$i);"+
		 newLine + "   }else{"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void valuedValued() {

		expected = "   if(destination.getAStringList()!=null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList(java.util.Arrays#asList(source.getStringArray()));"+
		 newLine + "   destination.getAStringList().addAll(listArrayOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void valuedNull() {
		
		expected = "   if(destination.getAStringList()!=null){"+
		 newLine + "   if(source.getStringArray()==null){"+
		 newLine + "   destination.setAStringList(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void nullValued() {

		expected = "   if(destination.getAStringList()==null){"+
		 newLine + "   if(source.getStringArray()!=null){"+
		 newLine + "   java.util.ArrayList listArrayOfDestination$i = new java.util.ArrayList(java.util.Arrays#asList(source.getStringArray()));"+
		 newLine + "   destination.setAStringList(listArrayOfDestination$i);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}	

}
