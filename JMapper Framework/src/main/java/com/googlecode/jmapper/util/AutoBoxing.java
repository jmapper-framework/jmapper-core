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

package com.googlecode.jmapper.util;

import java.util.HashMap;

/**
 * This class indicates the boxing and unboxing operations.
 * @author Alessandro Vurro
 *
 */
public final class AutoBoxing {

	private AutoBoxing() { }
	
	/** boxingOperations contains all combinations of boxing operations.
	 *  key = Wrapper Class name, value = primitive Class name */
	public static final HashMap<String, String[]> boxingOperations =
			
			new HashMap<String, String[]>(){
		
					private static final long serialVersionUID = -362094781411463739L;

					{
						put(Byte.class.getName(), 		new String[]{byte.class.getName()});
						put(Short.class.getName(), 		new String[]{short.class.getName()});
						put(Integer.class.getName(), 	new String[]{int.class.getName()});
						put(Long.class.getName(), 		new String[]{long.class.getName()});
						put(Float.class.getName(), 		new String[]{float.class.getName()});
						put(Double.class.getName(), 	new String[]{double.class.getName()});
						put(Character.class.getName(), 	new String[]{char.class.getName()});
						put(Boolean.class.getName(), 	new String[]{boolean.class.getName()});
						put(Number.class.getName(), 	new String[]{byte.class.getName(),
																	 short.class.getName(),
																	 int.class.getName(),
																	 float.class.getName(),
																	 double.class.getName(),
																	 long.class.getName()});
					}
			};
	
	/** boxingOperations contains all combinations of boxing operations.
	 *  key = Wrapper Class name, value = primitive Class name */
	public static final HashMap<String, String[]> unBoxingOperations =
					
			new HashMap<String, String[]>(){
				
					private static final long serialVersionUID = -362094781411463739L;

					{
						put(byte.class.getName(), 		new String[]{Byte.class.getName()});
						put(short.class.getName(), 		new String[]{Byte.class.getName(),Short.class.getName()});
						put(int.class.getName(), 	    new String[]{Byte.class.getName(),Short.class.getName(),Integer.class.getName()});
						put(long.class.getName(), 		new String[]{Long.class.getName()});
						put(float.class.getName(), 		new String[]{Float.class.getName()});
						put(double.class.getName(), 	new String[]{Double.class.getName()});
						put(char.class.getName(), 	    new String[]{Character.class.getName()});
						put(boolean.class.getName(), 	new String[]{Boolean.class.getName()});
					}
			};
}
