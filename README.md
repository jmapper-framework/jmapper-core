JMapper Framework is a java bean to java bean mapper, allows you to perform the passage of data dinamically with annotations and / or XML.<br>With JMapper you can:

  * create and enrich target objects
  * apply a specific logic to the mapping
  * automatically manage the XML file
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
With JMapper we have all the advantages of dynamic mapping with the performance of static code, with 0 memory consumption

```
<dependency>
   <groupId>com.googlecode.jmapper-framework</groupId>
   <artifactId>jmapper-core</artifactId>
   <version>1.3.1</version>
</dependency>
```
Not using Maven or any other software project management? Follow this (link)[http://search.maven.org/#browse%7C642809664] to download the dependencies.<br><b>Required java 1.5+</b>

