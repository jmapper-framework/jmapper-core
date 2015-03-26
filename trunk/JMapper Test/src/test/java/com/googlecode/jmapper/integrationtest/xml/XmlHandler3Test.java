package com.googlecode.jmapper.integrationtest.xml;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.exceptions.JMapperException;
import com.googlecode.jmapper.integrationtest.operations.bean.AnnotatedExampleClass;
import com.googlecode.jmapper.integrationtest.operations.bean.Class1;
import com.googlecode.jmapper.integrationtest.operations.bean.Class2;
import com.googlecode.jmapper.integrationtest.operations.bean.Class3;
import com.googlecode.jmapper.integrationtest.operations.bean.Inner;
import com.googlecode.jmapper.xml.Attribute;
import com.googlecode.jmapper.xml.Converter;
import com.googlecode.jmapper.xml.Global;
import com.googlecode.jmapper.xml.Value;
import com.googlecode.jmapper.xml.XML;
import com.googlecode.jmapper.xml.XmlHandler;

import junit.framework.TestCase;

public class XmlHandler3Test extends TestCase {

	private final static XmlHandler xmlHandler = new XmlHandler();
	private final static XML xml = xmlHandler.getXML();
	ByteArrayOutputStream log;
	
	public XmlHandler3Test(){
		log = new ByteArrayOutputStream();
		PropertyConfigurator.configure("log4j.properties");
		Logger.getLogger(JMapper.class).addAppender(new WriterAppender(new SimpleLayout(), log));
	}
	
	@Override
	protected void setUp() throws Exception {
		log.reset();
	}
	
	public void testAddClass(){
		// creo l'attributo da aggiungere
		String[] attributes = new String[]{"field1Class1","field1Class2","field1Class3"};
		Class<?>[]  classes = new Class []{Class1.class,Class2.class,Class3.class};
		Attribute attribute = new Attribute("field1", Converter.toTargetAttributes(attributes), classes);
		
		String[] excluded = new String[]{"field1Class1","field1Class2","field1Class3"};
		Global global = new Global("prova", classes, excluded);
		
		// avvio la funzione da testare
		xmlHandler.addClass(AnnotatedExampleClass.class, global, attribute);
		
		// carico la configurazione e ottengo la lista degli attributi associati alla classe
		List<Attribute> list =  xml.attributesLoad().get(AnnotatedExampleClass.class.getName());

		// la lista deve contenere un solo elemento
		assertEquals(1, list.size());
		// l'elemento recuperato dev'essere uguale a quello passato al metodo
		assertEquals(attribute, list.get(0));
		
		Global result = xml.globalsLoad().get(AnnotatedExampleClass.class.getName());
		assertEquals(global, result);
		
	}
	
	public void testAddClassException(){
		// creo l'attributo da aggiungere
		Attribute attribute = new Attribute("mappedField", new Value("targetField"));
			
		// avvio la funzione da testare
    	try{
    		xmlHandler.addClass(AnnotatedExampleClass.class, attribute);
		}catch(JMapperException e){}
		
		assertEquals("ERROR - XmlMappingClassExistException: AnnotatedExampleClass Class is present in the jmapper.xml configuration file"+newLine, log.toString());

	}
	
	public void testAddAttributes(){
		// creo l'attributo da aggiungere
		String[] attributes = new String[]{"field2Class1","field2Class2","field2Class3"};
		Class<?>[]  classes = new Class []{Class1.class,Class2.class,Class3.class};
		Attribute attribute = new Attribute("field2", Converter.toTargetAttributes(attributes), classes);
				
		xmlHandler.addAttributes(AnnotatedExampleClass.class, attribute)
				  .addAttributes(AnnotatedExampleClass.class, new Attribute("field3", new Value("targetField3")));
		
		// carico la configurazione e ottengo la lista degli attributi associati alla classe
		List<Attribute> list =  xml.attributesLoad().get(AnnotatedExampleClass.class.getName());
		// la lista deve contenere un solo elemento
		assertEquals(3, list.size());
		// l'elemento recuperato dev'essere uguale a quello passato al metodo addAttributes
		assertEquals(attribute, list.get(1));
	}
	
	public void testAddAttributesException(){
		// creo l'attributo da aggiungere
		String[] attributes = new String[]{"field2Class1","field2Class2","field2Class3"};
		Class<?>[]  classes = new Class []{Class1.class,Class2.class,Class3.class};
		Attribute attribute = new Attribute("nonEsiste", Converter.toTargetAttributes(attributes), classes);
		
		// il campo nonEsiste non è presente nella classe AnnotatedExampleClass
    	try{
    		xmlHandler.addAttributes(AnnotatedExampleClass.class, attribute);
		}catch(JMapperException e){}
		assertEquals("ERROR - IllegalArgumentException: nonEsiste field not found on AnnotatedExampleClass Class"+newLine, log.toString());
		log.reset();

		// il campo field1 è già configurato
		attribute.setName("field1");
    	try{
    		xmlHandler.addAttributes(AnnotatedExampleClass.class, attribute);
		}catch(JMapperException e){}
		assertEquals("ERROR - XmlMappingAttributeExistException: the field1 attribute already exist in AnnotatedExampleClass Class, check the jmapper.xml configuration file"+newLine, log.toString());
	}
	
	public void testDeleteAttributes(){
	
		// creo l'attributo da aggiungere
		String[] attributes = new String[]{"field1Class1","field1Class2","field1Class3"};
		Class<?>[]  classes = new Class []{Class1.class,Class2.class,Class3.class};
		Attribute attribute = new Attribute("field1", Converter.toTargetAttributes(attributes), classes);
		
		// elimino il campo field2 dall'XML
		xmlHandler.deleteAttributes(AnnotatedExampleClass.class, "field2");
		
		// carico la configurazione e ottengo la lista degli attributi associati alla classe
		List<Attribute> list =  xml.attributesLoad().get(AnnotatedExampleClass.class.getName());

		// la lista deve contenere un solo elemento
		assertEquals(2, list.size());
		// l'elemento recuperato dev'essere uguale a quello passato al metodo
		assertEquals(attribute, list.get(0));
	}
	
	public void testDeleteAttributesException(){
		
		// cerco di eliminare un attributo appartenente ad una classe non configurata
		try{
			xmlHandler.deleteAttributes(Class1.class, "field2");
		}catch(JMapperException e){}
		assertEquals("ERROR - XmlMappingClassDoesNotExistException: Class1 Class isn't present in the jmapper.xml configuration file"+newLine, log.toString());
		log.reset();
		
		// elimino un campo inesistente nella classe AnnotatedExampleClass
		try{
			xmlHandler.deleteAttributes(AnnotatedExampleClass.class, "campoInesistente");
		}catch(JMapperException e){}
		assertEquals("ERROR - IllegalArgumentException: campoInesistente field not found on AnnotatedExampleClass Class"+newLine, log.toString());
		log.reset();

		// provo a eliminare un campo non presente nel file xml 
		try{
			xmlHandler.deleteAttributes(AnnotatedExampleClass.class, "field2");
		}catch(JMapperException e){}
		assertEquals("ERROR - XmlMappingAttributeDoesNotExistException: in the jmapper.xml configuration file, field2 field does not exist in AnnotatedExampleClass Class"+newLine, log.toString());
		log.reset();
		
		xmlHandler.deleteAttributes(AnnotatedExampleClass.class, "field3");
		
		// se è configurato solo un campo per questa classe, allora utilizzare deleteClass
		try{
			xmlHandler.deleteAttributes(AnnotatedExampleClass.class, "field1");
		}catch(JMapperException e){}
		assertEquals("ERROR - WrongMethodException: AnnotatedExampleClass has only one attribute mapped, please use removeClass instead"+newLine, log.toString());
		log.reset();
		
	}
	
	public void testOverrideClass(){
		// creo l'attributo da aggiungere
		String[] attributes = new String[]{"field2Class1","field2Class2","field2Class3"};
		Class<?>[]  classes = new Class []{Class1.class,Class2.class,Class3.class};
		Attribute attribute = new Attribute("field2", Converter.toTargetAttributes(attributes), classes);

		String[] excluded = new String[]{"field1Class1","field1Class2","field1Class3"};
		Global global = new Global("override", classes, excluded);

		// avvio la funzione da testare
		xmlHandler.overrideClass(AnnotatedExampleClass.class, global, attribute);
				
		// carico la configurazione e ottengo la lista degli attributi associati alla classe
		List<Attribute> list =  xml.attributesLoad().get(AnnotatedExampleClass.class.getName());

		// la lista deve contenere un solo elemento
		assertEquals(1, list.size());
		// l'elemento recuperato dev'essere uguale a quello passato al metodo
		assertEquals(attribute, list.get(0));
		
		Global result =  xml.globalsLoad().get(AnnotatedExampleClass.class.getName());
		assertEquals(global, result);
	}
	
	public void testDeleteClass(){
		xmlHandler.deleteClass(AnnotatedExampleClass.class);
		// verifico che la classe sia stata eliminata
		assertNull(xml.attributesLoad().get(AnnotatedExampleClass.class.getName()));
	}
	
	public void testDeleteClassException(){
    	try{
    		xmlHandler.deleteClass(AnnotatedExampleClass.class);
		}catch(JMapperException e){}
		assertEquals("ERROR - XmlMappingClassDoesNotExistException: AnnotatedExampleClass Class isn't present in the jmapper.xml configuration file"+newLine, log.toString());
			
		// verifico che la classe sia stata eliminata
		assertNull(xml.attributesLoad().get(AnnotatedExampleClass.class.getName()));
	}
	
	public void testAddAnnotatedClass(){
		// creo la configurazione xml partendo dalle annotation
		xmlHandler.addAnnotatedClass(AnnotatedExampleClass.class)
		
		// creo la configurazione anche per una inner class
				  .addAnnotatedClassAll(Inner.class);
	}
	
	public void testOverrideAnnotatedClass(){
		// aggiorna le configurazioni XML delle classi annotate
    	try{
    		xmlHandler.overrideAnnotatedClass();
		}catch(JMapperException e){}

		// carico la configurazione e ottengo la lista degli attributi associati alla classe
		List<Attribute> list =  xml.attributesLoad().get(AnnotatedExampleClass.class.getName());

		// la lista deve contenere un solo elemento
		assertEquals(3, list.size());
	}

	public void testCleanAnnotatedClass(){
		
		// elimino le annotations dalla classe
		xmlHandler.cleanAnnotatedClass(AnnotatedExampleClass.class)
				  
		// testo la funziona anche con una inner class
				  .cleanAnnotatedClassAll(Inner.class);
				
	}
	
	public void testFromXmlToAnnotation(){
		// configuro con le annotation la classe passata analizzando l'xml
		xmlHandler.fromXmlToAnnotation(AnnotatedExampleClass.class);
		
		// testo la funziona anche con una inner class
		xmlHandler.fromXmlToAnnotationAll(Inner.class);
	}
	
	public void testDeleteAnnotatedClasses(){
		
		// elimino da jmapper.xml tutte le configurazioni relative
		// a classi configurate con annotation
		xmlHandler.deleteAnnotatedClasses();
		
		// verifico che non esista la configurazione xml della classe
		// AnnotatedExampleClass
		assertNull(xml.attributesLoad().get(AnnotatedExampleClass.class.getName()));
		assertNull(xml.attributesLoad().get(Inner.class.getName()));
		assertNull(xml.attributesLoad().get(Inner.Class.class.getName()));
	}
}
