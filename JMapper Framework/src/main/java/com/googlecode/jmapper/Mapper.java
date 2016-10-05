/**
 * Copyright (C) 2012 - 2016 Alessandro Vurro.
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
package com.googlecode.jmapper;

/**
 * This class permits to define immutable objects by handling the DestinationFactory class.
 * The final Mapper class extends it.
 *  
 * @author Alessandro Vurro
 *
 * @param <D> Destination class
 * @param <S> Source class
 */
public abstract class Mapper<D, S> implements IMapper<D, S> {
	
	/**
	 * destination factory instance
	 */
	private DestinationFactory<D> factory = null;

	public DestinationFactory<D> getDestinationFactory() {
		return this.factory;
	}

	public void setDestinationFactory(DestinationFactory<D> factory) {
		this.factory = factory;
	}

	
	
}
