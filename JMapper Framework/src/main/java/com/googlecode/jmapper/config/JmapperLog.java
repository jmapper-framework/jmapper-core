/**
 * Copyright (C) 2012 - 2015 Alessandro Vurro.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.googlecode.jmapper.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.exceptions.JMapperException;

/**
 * Custom logger to semplify exceptions handling.
 * 
 * @author Alessandro Vurro
 *
 */
public class JmapperLog {

	/** logger */
	private static final Logger logger = LoggerFactory.getLogger(JMapper.class);
	
	private JmapperLog(){}
	
	/**
	 * This method handles error log.
	 * 
	 * @param e exception to handle
	 */
	public static void ERROR(Throwable e) throws JMapperException{
		logger.error("{}: {}",e.getClass().getSimpleName(),e.getMessage());
		throw new JMapperException(e);
	}
}
