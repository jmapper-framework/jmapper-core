/**
 * Copyright (C) 2013 Alessandro Vurro.
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

package it.avutils.jmapper.config;

import static it.avutils.jmapper.constants.Constants.MSG_FILE;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This Class loads the jmapper.msg.properties file.
 * 
 * @author Alessandro Vurro
 *
 */
public final class MSG {
	
			public static Properties getProperties(){
				
				try{
					Properties properties = new Properties();
					InputStream stream = MSG.class.getResourceAsStream(MSG_FILE);
					if(stream == null)Error.fileNotFound();
					
					try                   { properties.load (stream);  } 
					catch (IOException e) { Error.unableLoadingFile(); }
					return properties;
					
				}catch (Exception e) { JmapperLog.ERROR(e);	return null; }
			}
			
}
