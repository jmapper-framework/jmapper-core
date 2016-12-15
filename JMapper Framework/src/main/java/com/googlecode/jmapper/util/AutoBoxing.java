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

package com.googlecode.jmapper.util;

import java.util.HashMap;

/**
 * This class indicates the boxing and unboxing operations.
 * @author Alessandro Vurro
 *
 */
public final class AutoBoxing {

	
	/** boxingOperations contains all combinations of boxing operations.
	 *  key = Wrapper Class name, value = primitive Class name */
	public static final HashMap<String, String[]> boxingOperations = new HashMap<String, String[]>();
	
	/** unboxingOperations contains all combinations of unboxing operations.
	 *  key = Wrapper Class name, value = primitive Class name */
	public static final HashMap<String, String[]> unBoxingOperations = new HashMap<String, String[]>();
	
	private AutoBoxing() { }

	static{
			
		boxingOperations.put(Byte.class.getName(),   	new String[]{byte.class.getName()});
		boxingOperations.put(Short.class.getName(), 	new String[]{short.class.getName()});
		boxingOperations.put(Integer.class.getName(), 	new String[]{int.class.getName()});
		boxingOperations.put(Long.class.getName(), 		new String[]{long.class.getName()});
		boxingOperations.put(Float.class.getName(), 	new String[]{float.class.getName()});
		boxingOperations.put(Double.class.getName(), 	new String[]{double.class.getName()});
		boxingOperations.put(Character.class.getName(), new String[]{char.class.getName()});
		boxingOperations.put(Boolean.class.getName(), 	new String[]{boolean.class.getName()});
		boxingOperations.put(Number.class.getName(), 	new String[]{byte.class.getName(),
																	 short.class.getName(),
																	 int.class.getName(),
																	 float.class.getName(),
																	 double.class.getName(),
																	 long.class.getName()});
					
		unBoxingOperations.put(byte.class.getName(), 	new String[]{Byte.class.getName()});
		unBoxingOperations.put(short.class.getName(), 	new String[]{Byte.class.getName(),Short.class.getName()});
		unBoxingOperations.put(int.class.getName(), 	new String[]{Byte.class.getName(),Short.class.getName(),Integer.class.getName()});
		unBoxingOperations.put(long.class.getName(), 	new String[]{Long.class.getName()});
		unBoxingOperations.put(float.class.getName(), 	new String[]{Float.class.getName()});
		unBoxingOperations.put(double.class.getName(), 	new String[]{Double.class.getName()});
		unBoxingOperations.put(char.class.getName(), 	new String[]{Character.class.getName()});
		unBoxingOperations.put(boolean.class.getName(), new String[]{Boolean.class.getName()});
	}
}
