#JMapper Framework [![Build Status](https://travis-ci.org/jmapper-framework/jmapper-core.svg?branch=master)](https://travis-ci.org/jmapper-framework/jmapper-core)
###Released version 1.4.2!
some bug fixed:
  * issue [#18](https://github.com/jmapper-framework/jmapper-core/issues/18) closed: now is possible to use the inherited mapping with RelationalJMapper

____
JMapper is a java bean to java bean mapper, it allows to perform the passage of data dinamically with **annotations** and / or **XML**.<br>With JMapper you can:

  * **create** and **enrich** target objects
  * apply a **specific logic**
  * Annotation - XML convertion
  * implement the **One to Many** and **Many to One** relationships
  * implement explicit conversions
  * apply inherited configurations

##the most important feature is the ease of use

<b>Configuration</b>

```java
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

```java
Source source = new Source("id", "sourceField", "other");

JMapper<Destination, Source> mapper = new JMapper<>(Destination.class, Source.class);

Destination destination = mapper.getDestination(source);
```

<b>Result</b>

```java
destination ["id", "sourceField", null]
```
*With JMapper we have all the advantages of dynamic mapping with the performance of static code, with 0 memory consumption.*<br>
**Required java 5+**<br><br>
**issues status**
<br>[![Stories in Progress](https://badge.waffle.io/jmapper-framework/jmapper-core.png?label=In Progress&title=In Progress)](https://waffle.io/jmapper-framework/jmapper-core)<br><br>
**Dependency information**
<br>[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.googlecode.jmapper-framework/jmapper-core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.googlecode.jmapper-framework/jmapper-core) [![Dependency Status] (https://www.versioneye.com/user/projects/5539172d1d2989cb78000002/badge.svg?style=flat)](https://www.versioneye.com/user/projects/5539172d1d2989cb78000002)<br>

**For a complete guide**<br>[wiki](https://github.com/jmapper-framework/jmapper-core/wiki) pages<br><br>
**Do you like the project? think it has good potential?**<br>
Let us know any malfunctions, new features and more through the [JMapper Framework group](https://groups.google.com/forum/#!forum/jmapper-framework).<br><br>

**Do you want to contribute to the development of JMapper?**<br> 
There are many features to be implemented, such as:
- Eclipse plugin
- Integration with Hibernate, Apache Camel and other frameworks
- Fluent API that generate XML configuration
- and more..

contact us (jmapper.framework@gmail.com) for more information.<br><br>
**You want to do a friendly chat?**<br>
[![Join the chat at https://gitter.im/jmapper-framework/jmapper-core](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/jmapper-framework/jmapper-core?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)<br><br>

**Follow us on twitter**<br>
<a href="https://twitter.com/jmapper_av"><img src="http://www.teachthought.com/wp-content/uploads/2012/10/twitter-logo-break.png" width="120" height="120" /></a>

