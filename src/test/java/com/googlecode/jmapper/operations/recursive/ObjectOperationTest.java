package com.googlecode.jmapper.operations.recursive;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
import java.lang.reflect.Field;
import com.googlecode.jmapper.bean.ComplexClass;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

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
		
		expected = "   if(source.getMappedObject()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject obj$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   obj$i.setField(source.getMappedObject().getField());"+
		 newLine + "   destination.setTargetObject(obj$i);"+
		 newLine + "   }else{"+
		 newLine + "   destination.setTargetObject(null);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(destination.getTargetObject()!=null){"+
		 newLine + "   if(source.getMappedObject()!=null){"+
		 newLine + "   destination.getTargetObject().setField(source.getMappedObject().getField());"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   destination.setTargetObject(null);"+
		 newLine + "   }"+
		 newLine + "   }else{"+
		 newLine + "   if(source.getMappedObject()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject obj$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   obj$i.setField(source.getMappedObject().getField());"+
		 newLine + "   destination.setTargetObject(obj$i);"+
		 newLine + "   }else{"+
		 newLine + "   destination.setTargetObject(null);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();
	}

	@Override
	protected void AllValued() {
		
		expected = "   if(source.getMappedObject()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject obj$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   obj$i.setField(source.getMappedObject().getField());"+
		 newLine + "   destination.setTargetObject(obj$i);"+
		 newLine + "   }"+newLine;
		
		write(newInstance);
		verify();
		
		expected = "   if(source.getMappedObject()!=null){"+
		 newLine + "   if(destination.getTargetObject()!=null){"+
		 newLine + "   if(source.getMappedObject().getField()!=null){"+
		 newLine + "   destination.getTargetObject().setField(source.getMappedObject().getField());"+
		 newLine + "   }"+
		 newLine +
		 newLine + "   }else{"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject obj$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   obj$i.setField(source.getMappedObject().getField());"+
		 newLine + "   destination.setTargetObject(obj$i);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
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
		
		write(enrichment);
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
		
		write(enrichment);
		verify();	
	}

	@Override
	protected void ValuedNull() {
		
		expected = "   if(destination.getTargetObject()!=null){"+
	     newLine + "   if(source.getMappedObject()==null){"+
	     newLine + "   destination.setTargetObject(null);"+
	     newLine + "   }"+
	     newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}

	@Override
	protected void NullValued() {

		expected = "   if(destination.getTargetObject()==null){"+
		 newLine + "   if(source.getMappedObject()!=null){"+
		 newLine + "   com.googlecode.jmapper.bean.TargetObject obj$i = new com.googlecode.jmapper.bean.TargetObject();"+
		 newLine + "   obj$i.setField(source.getMappedObject().getField());"+
		 newLine + "   destination.setTargetObject(obj$i);"+
		 newLine + "   }"+
		 newLine + "   }"+newLine;
		
		write(enrichment);
		verify();		
	}	
}