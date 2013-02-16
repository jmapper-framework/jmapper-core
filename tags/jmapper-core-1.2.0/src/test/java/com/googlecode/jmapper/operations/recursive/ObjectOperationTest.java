package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.util.ClassesManager.getFieldValue;
import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;

import com.googlecode.jmapper.operations.info.InfoOperation;
import com.googlecode.jmapper.operations.recursive.ObjectOperation;

import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;

public class ObjectOperationTest extends AOperation<ObjectOperation>{

	@Override
	protected Field getDField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("targetObject");
	}

	@Override
	protected Field getSField() throws NoSuchFieldException {
		return ComplexClass.class.getDeclaredField("mappedObject");
	}

	@Override
	protected ObjectOperation getOperationIstance() {
		return new ObjectOperation();
	}
	
	@Override
	protected InfoOperation getInfoOperation() {
		return new InfoOperation();
	}

	
	@Override
	protected void AllAll() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getMappedObject()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject obj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   obj"+i+".setField(source.getMappedObject().getField());"+
		 newLine + "   destination.setTargetObject(obj"+i+");"+
		 newLine + "   }else{"+
		 newLine + "   destination.setTargetObject(null);"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getTargetObject()!=null){"+
		 newLine + "   if(source.getMappedObject()!=null){"+
		 newLine + "   destination.getTargetObject().setField(source.getMappedObject().getField());"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setTargetObject(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getMappedObject()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject obj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   obj"+i+".setField(source.getMappedObject().getField());"+
		 newLine + "   destination.setTargetObject(obj"+i+");"+
		 newLine + "   }else{"+
		 newLine + "   destination.setTargetObject(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual   = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void AllValued() {
		
		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getMappedObject()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject obj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   obj"+i+".setField(source.getMappedObject().getField());"+
		 newLine + "   destination.setTargetObject(obj"+i+");"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(newInstance).toString();
		verify();
		
		i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(source.getMappedObject()!=null){"+
		 newLine + "   if(destination.getTargetObject()!=null){"+
		 newLine + "   if(source.getMappedObject().getField()!=null){"+
		 newLine + "   destination.getTargetObject().setField(source.getMappedObject().getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject obj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   obj"+i+".setField(source.getMappedObject().getField());"+
		 newLine + "   destination.setTargetObject(obj"+i+");"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();
	}

	@Override
	protected void ValuedAll() {
		
		expected = "   if(destination.getTargetObject()!=null){"+
		 newLine + "   if(source.getMappedObject()!=null){"+
		 newLine + "   if(destination.getTargetObject().getField()!=null){"+
		 newLine + "   destination.getTargetObject().setField(source.getMappedObject().getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setTargetObject(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedValued() {

		expected = "   if(destination.getTargetObject()!=null){"+
		 newLine + "   if(source.getMappedObject()!=null){"+
		 newLine + "   if(destination.getTargetObject().getField()!=null){"+
		 newLine + "   if(source.getMappedObject().getField()!=null){"+
		 newLine + "   destination.getTargetObject().setField(source.getMappedObject().getField());"+
		 newLine + "   }"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getTargetObject()!=null){"+
	     newLine + "   if(source.getMappedObject()==null){"+
	     newLine + "   destination.setTargetObject(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}

	@Override
	protected void NullValued() {

		Integer i =  (Integer) getFieldValue(operation,"count");
		
		expected = "   if(destination.getTargetObject()==null){"+
		 newLine + "   if(source.getMappedObject()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject obj"+i+" = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   obj"+i+".setField(source.getMappedObject().getField());"+
		 newLine + "   destination.setTargetObject(obj"+i+");"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		actual	 = operation.write(enrichment).toString();
		verify();		
	}	
}