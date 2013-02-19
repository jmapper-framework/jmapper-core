package com.googlecode.jmapper.integrationtest.config

class PerformanceWriter {

	private static File file = new File("performance.txt")
	
	static write(String str){
		file.append(str+"\n")
	}
}
