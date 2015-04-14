package com.googlecode.jmapper.integrationtest.operations.bean;
import com.googlecode.jmapper.annotations.JMapAccessors;
import com.googlecode.jmapper.annotations.JMapAccessor;
import com.googlecode.jmapper.annotations.JGlobalMap;
import com.googlecode.jmapper.annotations.JMap;

@JMapAccessors({
      @JMapAccessor(name="gsf2", get="gsf2g", set="gsf2s"),
   @JMapAccessor(name="sField1", get="sField1Get", set="sField1Set")
})
@JGlobalMap(value="sField1", attributes={"gsf2"})
public class AnnotatedExampleClass3 {

@JMapAccessors({
      @JMapAccessor(name="sf2", get="sf2g", set="sf2s"),
      @JMapAccessor(name="sf3", get="sf3g", set="sf3s"),
   @JMapAccessor(name="field", get="getDestField1", set="setDestField1")
})
@JMap(value="sField1", attributes={"sf2", "sf3"})
	private String field;
	
}
