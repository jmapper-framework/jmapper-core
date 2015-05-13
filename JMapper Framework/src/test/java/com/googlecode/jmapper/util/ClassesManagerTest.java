package com.googlecode.jmapper.util;

import static com.googlecode.jmapper.util.ClassesManager.getGenericString;

import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

public class ClassesManagerTest extends TestCase{

	List<String> strings;
	Map<? extends String, String> map;
	
	public void testGetGenericString() throws SecurityException, NoSuchFieldException{
		String actual = getGenericString(this.getClass().getDeclaredField("strings"));
		assertEquals("java.util.List<java.lang.String>", actual); 
		actual = getGenericString(this.getClass().getDeclaredField("map"));
		assertEquals("java.util.Map<? extends java.lang.String, java.lang.String>", actual);
	}
}
