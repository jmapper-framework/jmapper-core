package com.googlecode.jmapper.operations.simple;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.lang.reflect.Field;

import com.googlecode.jmapper.bean.SimpleClass;
import com.googlecode.jmapper.enums.ConversionType;
import com.googlecode.jmapper.operations.AOperation;
import com.googlecode.jmapper.operations.info.InfoOperation;

public class BasicConversion5Test extends AOperation<BasicOperation>{

    @Override
    protected Field getDField() throws NoSuchFieldException {
        return SimpleClass.class.getDeclaredField("aIntField");
    }

    @Override
    protected Field getSField() throws NoSuchFieldException {
        return SimpleClass.class.getDeclaredField("aCharacterField");
    }

    @Override
    protected BasicOperation getOperationIstance() {
        return new BasicOperation();
    }
    
    @Override
    protected InfoOperation getInfoOperation() {
        return new InfoOperation().setConversionType(ConversionType.FromCharacterToint);
    }
    
    @Override
    protected void AllAll() {
        expected = "   destination.setAIntField((int) source.getACharacterField().charValue());"+newLine;
        write();
        verify();
    }

    @Override
    protected void AllValued() {
        expected = "   if(source.getACharacterField()!=null){"+
         newLine + "   destination.setAIntField((int) source.getACharacterField().charValue());"+
         newLine + "   }"+newLine;
        write();
        verify();
    }

    @Override
    protected void ValuedAll() {
        expected = "   destination.setAIntField((int) source.getACharacterField().charValue());"+newLine;
        write();
        verify();   
    }

    @Override
    protected void ValuedValued() {
        expected = "   if(source.getACharacterField()!=null){"+
         newLine + "   destination.setAIntField((int) source.getACharacterField().charValue());"+
         newLine + "   }"+newLine;
        write();
        verify();   
    }

    @Override
    protected void ValuedNull() {
        expected = newLine;
        write();
        verify();       
    }

    @Override
    protected void NullValued() {
        expected = newLine;
        write();
        verify();       
    }

}
