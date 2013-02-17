package com.googlecode.jmapper.integrationtest.config


import groovy.text.SimpleTemplateEngine

class TestWriter {

	static main(args) {
		
		def testName = 'MappedArrayList'
		
		def vars = ['testName':testName]
		
		def engine = new SimpleTemplateEngine()
		
		def beanDTemplate = engine.createTemplate(new File("src/main/resources/BeanD.template"))
		def beanSTemplate = engine.createTemplate(new File("src/main/resources/BeanS.template"))
		def mockDSTemplate = engine.createTemplate(new File("src/main/resources/MockDS.template"))
		def mockSTemplate = engine.createTemplate(new File("src/main/resources/MockS.template"))
		def testDSTemplate = engine.createTemplate(new File("src/main/resources/TestDS.template"))
		def testSTemplate = engine.createTemplate(new File("src/main/resources/TestS.template"))
		
		def beanDResult = beanDTemplate.make(vars)
		def beanSResult = beanSTemplate.make(vars)
		def mockDSResult = mockDSTemplate.make(vars)
		def mockSResult = mockSTemplate.make(vars)
		def testDSResult = testDSTemplate.make(vars)
		def testSResult = testSTemplate.make(vars)
		
		beanDResult.writeTo(new FileWriter("src/test/java/it/avutils/jmapper/integrationtest/operations/bean/${testName}D.java"))
		beanSResult.writeTo(new FileWriter("src/test/java/it/avutils/jmapper/integrationtest/operations/bean/${testName}S.java"))
		mockDSResult.writeTo(new FileWriter("src/test/java/it/avutils/jmapper/integrationtest/operations/mock/${testName}MockDS.java"))
		mockSResult.writeTo(new FileWriter("src/test/java/it/avutils/jmapper/integrationtest/operations/mock/${testName}MockS.java"))
		testDSResult.writeTo(new FileWriter("src/test/java/it/avutils/jmapper/integrationtest/operations/${testName}DSTest.java"))
		testSResult.writeTo(new FileWriter("src/test/java/it/avutils/jmapper/integrationtest/operations/${testName}STest.java"))
	}

}
