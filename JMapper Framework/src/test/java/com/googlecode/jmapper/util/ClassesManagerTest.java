package com.googlecode.jmapper.util;

import static com.googlecode.jmapper.util.ClassesManager.getGenericString;

import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLEngineResult.Status;

import junit.framework.TestCase;

public class ClassesManagerTest extends TestCase{

	public List<String> strings;
	public List<Status> strings2;
	public Map<? extends String, String> map;
	public Map<? extends String, Status> map2;
	public Map<? extends Status, Status> map3;
	
	public void testGetGenericString() throws SecurityException, NoSuchFieldException{
		String actual = getGenericString(this.getClass().getDeclaredField("strings"));
		assertEquals("java.util.List<java.lang.String>", actual); 
		actual = getGenericString(this.getClass().getDeclaredField("strings2"));
		assertEquals("java.util.List<javax.net.ssl.SSLEngineResult$Status>", actual); 
		actual = getGenericString(this.getClass().getDeclaredField("map"));
		assertEquals("java.util.Map<? extends java.lang.String, java.lang.String>", actual);
		actual = getGenericString(this.getClass().getDeclaredField("map2"));
		assertEquals("java.util.Map<? extends java.lang.String, javax.net.ssl.SSLEngineResult$Status>", actual);
		actual = getGenericString(this.getClass().getDeclaredField("map3"));
		assertEquals("java.util.Map<? extends javax.net.ssl.SSLEngineResult$Status, javax.net.ssl.SSLEngineResult$Status>", actual);
	}
}
