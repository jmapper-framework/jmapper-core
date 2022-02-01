package com.googlecode.jmapper.util;

import com.googlecode.jmapper.xml.beans.XmlAttribute;
import com.googlecode.jmapper.xml.beans.XmlJmapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class FileManagerTest {

    @Test
    public void readAtRuntimeTest() throws IOException {
        XmlJmapper xmlJmapper = FilesManager.readAtRuntime("com/googlecode/jmapper/config/TestJMapper.xml");
        List<XmlAttribute> t = xmlJmapper.classes.get(0).attributes;
        Assert.assertEquals(t.size(),2);
        Assert.assertEquals(t.get(0).value.name,"id");
        Assert.assertEquals(t.get(1).value.name,"sourceField");
    }
}
