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
    protected void allAll() {
        expected = "   destination.setAIntField((int) source.getACharacterField().charValue());"+newLine;
        write();
        verify();
    }

    @Override
    protected void allValued() {
        expected = "   if(source.getACharacterField()!=null){"+
         newLine + "   destination.setAIntField((int) source.getACharacterField().charValue());"+
         newLine + "   }"+newLine;
        write();
        verify();
    }

    @Override
    protected void valuedAll() {
        expected = "   destination.setAIntField((int) source.getACharacterField().charValue());"+newLine;
        write();
        verify();   
    }

    @Override
    protected void valuedValued() {
        expected = "   if(source.getACharacterField()!=null){"+
         newLine + "   destination.setAIntField((int) source.getACharacterField().charValue());"+
         newLine + "   }"+newLine;
        write();
        verify();   
    }

    @Override
    protected void valuedNull() {
        expected = newLine;
        write();
        verify();       
    }

    @Override
    protected void nullValued() {
        expected = newLine;
        write();
        verify();       
    }

}
