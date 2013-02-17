package com.googlecode.jmapper.integrationtest;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.enums.ChooseConfig;

import com.googlecode.jmapper.integrationtest.config.Constants;
import com.googlecode.jmapper.integrationtest.mock.IMockDS;

public class BuilderDS<D,S> extends AbstractDS<D,S> {

	/** name of Class Test */
	private String className = this.getClass().getSimpleName();
	
	/** package of beans */
	private final String beanPackage = Constants.BEAN_PACKAGE;
	
	/** package of mocks */
	private final String mockPackage = Constants.MOCK_PACKAGE;
	
	public BuilderDS() {
		className = className.substring(0,className.indexOf(Constants.DS_TEST_SUFFIX));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JMapper<D,S> getJMapper() {
		
		Class<D> destination = null;
		Class<S> source = null;
		PropertyConfigurator.configure("log4j.properties");
		try {	destination = (Class<D>) Class.forName(beanPackage+className+Constants.D_BEAN_SUFFIX);
				source = (Class<S>) Class.forName(beanPackage+className+Constants.S_BEAN_SUFFIX);
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		
		return new JMapper<D,S>(destination, source,ChooseConfig.SOURCE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public IMockDS<D,S> getMockDS() {
		Class<?> mockDS = null;
		
		try {	mockDS = Class.forName(mockPackage+className+Constants.DS_MOCK_SUFFIX);
				return (IMockDS<D, S>) mockDS.newInstance();
		} catch (Exception e) {e.printStackTrace();}

		return null;
	}

}
