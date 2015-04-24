[![Build Status](https://travis-ci.org/jmapper-framework/jmapper-core.svg?branch=master)](https://travis-ci.org/jmapper-framework/jmapper-core)  [![Dependency Status] (https://www.versioneye.com/user/projects/5539172d1d2989cb78000002/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5539172d1d2989cb78000002)

<b>We are in migration phase, please visit https://code.google.com/p/jmapper-framework/ for more information.</b>

JMapper Framework is a java bean to java bean mapper, allows you to perform the passage of data dinamically with annotations and / or XML.<br>With JMapper you can:

  * create and enrich target objects
  * apply a specific logic to the mapping (apply mapping only on null fields for example)
  * Annotation <-> XML converter and other utilies
  * implement the 1 to N and N to 1 relationships
  * implement explicit conversions
  * apply inherited configurations

##the most important feature is the ease of use

<b>Configuration</b>

```
class Destination{                      class Source{
    @JMap
    private String id;                      private String id;
    @JMap("sourceField")                    
    private String destinationField;        private String sourceField;
    private String other;                   private String other;

    // getters and setters...               // getters and setters...
}                                       }
```

<b>Usage</b>

```
Source source = new Source("id", "sourceField", "other");

JMapper mapper = new JMapper(Destination.class, Source.class);

Destination destination = (Destination) mapper.getDestination(source);
```

<b>Result</b>

```
destination ["id", "sourceField", null]
```
With JMapper we have all the advantages of dynamic mapping with the performance of static code, with 0 memory consumption.

```
<dependency>
   <groupId>com.googlecode.jmapper-framework</groupId>
   <artifactId>jmapper-core</artifactId>
   <version>1.3.1</version>
</dependency>
```

<b>JMapper Group:</b> https://groups.google.com/forum/#!forum/jmapper-framework<br>
<b>Documentation:</b> http://jmapper-framework.github.io/jmapper-core

Not using Maven or any other software project management? Follow this [link](http://search.maven.org/#browse%7C642809664) to download the jar.<br><b>Required java 1.5+</b>

