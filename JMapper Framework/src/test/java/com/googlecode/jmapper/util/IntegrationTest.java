package com.googlecode.jmapper.util;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import com.googlecode.jmapper.bean.Destination;
import com.googlecode.jmapper.bean.Source;
import org.junit.Assert;
import org.junit.Test;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

public class IntegrationTest {
        private JMapperAPI getJMapperAPI(){
            return  new JMapperAPI()
                .add(mappedClass(Destination.class)
                    .add(attribute("id")
                            .value("id"))
                    .add(attribute("destinationField")
                            .value("sourceField")));
}

    @Test
    public void getJmapperApiTest(){

        Source source = new Source("id", "sourceField", "other");
        JMapper<Destination, Source> mapper = new JMapper<>(Destination.class, Source.class, getJMapperAPI());
        Destination destination= mapper.  getDestination(source);
        Assert.assertEquals(destination.getId(),source.getId());
        Assert.assertEquals(destination.getDestinationField(),source.getSourceField());
    }

}
