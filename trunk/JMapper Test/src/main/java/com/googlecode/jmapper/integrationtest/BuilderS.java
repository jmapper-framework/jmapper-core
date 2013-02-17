package com.googlecode.jmapper.integrationtest;

import org.apache.log4j.PropertyConfigurator;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.enums.ChooseConfig;

import com.googlecode.jmapper.integrationtest.config.Constants;
import com.googlecode.jmapper.integrationtest.mock.IMockS;

public class BuilderS<D,S> extends AbstractS<D,S> {

	
	/** name of Class Test */
	private String className = this.getClass().getSimpleName();
	
	/** package of beans */
	private final String beanPackage = Constants.BEAN_PACKAGE;
	
	/** package of mocks */
	private final String mockPackage = Constants.MOCK_PACKAGE;
	
	public BuilderS() {
		className = className.substring(0,className.indexOf(Constants.S_TEST_SUFFIX));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JMapper<D,S> getJMapper() {
		PropertyConfigurator.configure("log4j.properties");
		try {	Class<D> destination = (Class<D>) Class.forName(beanPackage+className+Constants.D_BEAN_SUFFIX);
				Class<S> source      = (Class<S>) Class.forName(beanPackage+className+Constants.S_BEAN_SUFFIX);
				return new JMapper<D,S>(destination, source,ChooseConfig.SOURCE);
		} catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IMockS<D,S> getMockS() {
		try {	Class<?> mockS = Class.forName(mockPackage+className+Constants.S_MOCK_SUFFIX);
				return (IMockS<D, S>) mockS.newInstance();
		} catch (Exception e) {e.printStackTrace();}
		return null;
	}

}
