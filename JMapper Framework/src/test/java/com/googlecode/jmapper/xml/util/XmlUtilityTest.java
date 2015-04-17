package com.googlecode.jmapper.xml.util;


import java.lang.reflect.Method;
import java.util.HashMap;

import com.googlecode.jmapper.annotations.JMap;
import com.googlecode.jmapper.util.FilesManager;

import junit.framework.TestCase;

public class XmlUtilityTest extends TestCase {

	FilesManager fm = new FilesManager();
	
	@SuppressWarnings("unchecked")
	public void testSubtractJMap(){
		
		Method subtractJMap,verifyLine,cleanLine;
		try {
			subtractJMap = FilesManager.class.getDeclaredMethod("subtractAnnotation", String.class, new Class<?>[]{}.getClass());
			verifyLine = FilesManager.class.getDeclaredMethod("verifyLine", String.class);
			cleanLine = FilesManager.class.getDeclaredMethod("cleanLine", String.class,boolean.class, new Class<?>[]{}.getClass());
			subtractJMap.setAccessible(true);
			verifyLine.setAccessible(true);
			cleanLine.setAccessible(true);
			
			String line = "@JMap";
			assertEquals("", subtractJMap.invoke(fm,line, new Class<?>[]{JMap.class}));
	
			line = " qualcosaQua   @JMap";
			assertEquals(" qualcosaQua   ", subtractJMap.invoke(fm,line, new Class<?>[]{JMap.class}));
			
			line = " qualcosaQua   @JMap eQua";
			assertEquals(" qualcosaQua    eQua", subtractJMap.invoke(fm,line, new Class<?>[]{JMap.class}));
	
			line = " qualcosaQua   @JMap eQua";
			assertEquals(" qualcosaQua    eQua", subtractJMap.invoke(fm,line, new Class<?>[]{JMap.class}));
			
			line = " qualcosaQua   @JMap (eQua)";
			assertEquals(" qualcosaQua   ", subtractJMap.invoke(fm,line, new Class<?>[]{JMap.class}));
			
			line = " qualcosaQua   @JMap (asdasd)z";
			assertEquals(" qualcosaQua   z", subtractJMap.invoke(fm,line, new Class<?>[]{JMap.class}));
			
			line = " qualcosaQua   @JMap (";
			assertEquals(" qualcosaQua   newLine", subtractJMap.invoke(fm,line, new Class<?>[]{JMap.class}));
			
			line = " altroContenuto = asdasd) private final";
			assertEquals(" private final", verifyLine.invoke(fm,line));
			
			line = " altroContenuto = asdasd, altroContenuto = asdasd";
			assertEquals("newLine", verifyLine.invoke(fm,line));
		
			String annotation = " @JMap ";
			HashMap<String, Object> result = (HashMap<String, Object>) cleanLine.invoke(fm, annotation,false, new Class<?>[]{JMap.class});
			boolean newLine = (Boolean) result.get("newLine");
			line = (String) result.get("result");
			assertEquals(false, newLine);
			assertNull(line);
			
			annotation = " @JMap (value = \"targetField\" ";
			result = (HashMap<String, Object>) cleanLine.invoke(fm, annotation,false, new Class<?>[]{JMap.class});
			newLine = (Boolean) result.get("newLine");
			line = (String) result.get("result");
			assertEquals(true, newLine);
			assertNull(line);
			
			annotation = " attributes = {\"targetField\"} ";
			result = (HashMap<String, Object>) cleanLine.invoke(fm, annotation,true, new Class<?>[]{JMap.class});
			newLine = (Boolean) result.get("newLine");
			line = (String) result.get("result");
			assertEquals(true, newLine);
			assertNull(line);
			
			annotation = " classes = {TargetClass.class}) ";
			result = (HashMap<String, Object>) cleanLine.invoke(fm, annotation,true, new Class<?>[]{JMap.class});
			newLine = (Boolean) result.get("newLine");
			line = (String) result.get("result");
			assertEquals(false, newLine);
			assertNull(line);
			
		} catch (Exception e) {assertTrue(false);e.printStackTrace();}
	}
}
