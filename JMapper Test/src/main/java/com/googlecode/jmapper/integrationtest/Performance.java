package com.googlecode.jmapper.integrationtest;

import static com.googlecode.jmapper.util.GeneralUtility.newLine;
//import static com.googlecode.jmapper.integrationtest.config.PerformanceWriter.write;
import com.googlecode.jmapper.integrationtest.config.Constants;
import java.util.concurrent.Callable;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.enums.ChooseConfig;

import bb.util.Benchmark;
import junit.framework.TestCase;

public abstract class Performance<D,S> extends TestCase {
	
	/** name of Class Test */
	private String className = this.getClass().getSimpleName();
	
	/** package of beans */
	private final String beanPackage = Constants.BEAN_PACKAGE;
	
	/** instance of  JMapper */
	private JMapper<D, S> mapper;

	@SuppressWarnings("unchecked")
	public Performance() {
		className = className.substring(0,className.indexOf("PerformanceTest"));
		Class<D> destination = null;
		Class<S> source = null;
		try {	destination = (Class<D>) Class.forName(beanPackage+className+"D");
				source = (Class<S>) Class.forName(beanPackage+className+"S");
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		mapper = new JMapper<D,S>(destination, source,ChooseConfig.SOURCE);
	}

	/**
	 * @param source source of data to be mapped
	 * @return a new instance of Destination
	 */
	protected abstract D staticMapping(S source);
	
	/**
	 * @return an instance of Source
	 */
	protected abstract S getSource();
	
	/** This method defines the weight of the computation.
	 * @return the weight of the computation
	 */
	protected abstract int getInternalWeight();
	
	/** This method defines the title of this test.
	 * @return the title of this test
	 */
	protected abstract String titleOfTest();
	
	public void testStaticMapping(){
		//write(newLine+titleOfTest()+newLine);
		try {
			Benchmark staticMapping = new Benchmark(new Callable<D>() {
											public D call() throws Exception {
												return staticMapping(getSource());
											}
									  }, true, getInternalWeight());
			
		//	write("  static mapping:		"+staticMapping);
		} catch (Exception e) {e.printStackTrace();}
	}
	
	public void testDynamicMapping(){
		try {
			Benchmark dynamicMapping = new Benchmark(new Callable<D>() {
										public D call() throws Exception {
											return mapper.getDestinationWithoutControl(getSource());
										}
								  }, true, getInternalWeight());
		//	write("  dynamic mapping:		"+dynamicMapping);
		} catch (Exception e) {e.printStackTrace();}
	}
	
}
