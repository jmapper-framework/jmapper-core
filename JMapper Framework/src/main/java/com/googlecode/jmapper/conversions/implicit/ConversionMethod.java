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

package com.googlecode.jmapper.conversions.implicit;

/**
 * This Class defines conversion methods between primitive and wrapper types in literal version.
 * 
 * @author Alessandro Vurro
 *
 */
public final class ConversionMethod{

	/*  STRING METHODS  */
	public static String frombyteToString(final String source)     {	return "Byte.toString("+source+")";			}
	public static String fromshortToString(final String source)    {	return "Short.toString("+source+")";		}
	public static String fromintToString(final String source)      {	return "Integer.toString("+source+")";		}
	public static String fromlongToString(final String source)     {	return "Long.toString("+source+")";			}
	public static String fromfloatToString(final String source)    {	return "Float.toString("+source+")";		}
	public static String fromdoubleToString(final String source)   {	return "Double.toString("+source+")";		}
	public static String fromcharToString(final String source) 	   {	return "Character.toString("+source+")";	}
	public static String frombooleanToString(final String source)  {	return "Boolean.toString("+source+")";		}
	
	public static String fromByteToString(final String source)     {	return source+".toString()";				}
	public static String fromShortToString(final String source)    {	return source+".toString()";				}
	public static String fromIntegerToString(final String source)  {	return source+".toString()";				}
	public static String fromLongToString(final String source)     {	return source+".toString()";				}
	public static String fromFloatToString(final String source)    {	return source+".toString()";				}
	public static String fromDoubleToString(final String source)   {	return source+".toString()";				}
	public static String fromCharacterToString(final String source){	return source+".toString()";				}
	public static String fromBooleanToString(final String source)  {	return source+".toString()";				}

	
	/*  BYTE METHODS  */
	public static String fromshortToByte(final String source) 	  {	return "new Byte((byte) "+source+")";		}
	public static String fromintToByte(final String source)       { return "new Byte((byte) "+source+")";		}
	public static String fromlongToByte(final String source) 	  { return "new Byte((byte) "+source+")";		}
	public static String fromfloatToByte(final String source) 	  { return "new Byte((byte) "+source+")";		}
	public static String fromdoubleToByte(final String source) 	  { return "new Byte((byte) "+source+")";		}
	public static String fromcharToByte(final String source) 	  { return "new Byte((byte) "+source+")";							}
	public static String frombooleanToByte(final String source)   { return "new Byte("+source+"?(byte)1:(byte)0)";   				}
	
	public static String fromStringToByte(final String source) 	  { return "new Byte("+source+")";				}
	public static String fromShortToByte(final String source) 	  {	return "new Byte("+source+".byteValue())";	}
	public static String fromIntegerToByte(final String source)   { return "new Byte("+source+".byteValue())";	}
	public static String fromLongToByte(final String source) 	  { return "new Byte("+source+".byteValue())";	}
	public static String fromFloatToByte(final String source) 	  { return "new Byte("+source+".byteValue())";	}
	public static String fromDoubleToByte(final String source) 	  { return "new Byte("+source+".byteValue())";	}
	public static String fromCharacterToByte(final String source) { return "new Byte((byte)"+source+".charValue())";				}
	public static String fromBooleanToByte(final String source)   { return "new Byte("+source+".booleanValue()?(byte)1:(byte)0)";   }
	
	public static String fromshortTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String fromintTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String fromlongTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String fromfloatTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String fromdoubleTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String fromcharTobyte(final String source) 	  { return "(byte) "+source;					}
	public static String frombooleanTobyte(final String source)   { return source+"?(byte)1:(byte)0";     		}
	
	public static String fromStringTobyte(final String source) 	  { return "Byte.parseByte("+source+")";		}
	public static String fromShortTobyte(final String source) 	  { return source+".byteValue()";				}
	public static String fromIntegerTobyte(final String source)	  { return source+".byteValue()";				}
	public static String fromLongTobyte(final String source) 	  { return source+".byteValue()";				}
	public static String fromFloatTobyte(final String source) 	  { return source+".byteValue()";				}
	public static String fromDoubleTobyte(final String source)    { return source+".byteValue()";				}
	public static String fromCharacterTobyte(final String source) { return "(byte) "+source+".charValue()";		}
	public static String fromBooleanTobyte(final String source)   { return source+".booleanValue()?(byte)1:(byte)0";   }

	
	/*  SHORT METHODS  */
	public static String frombyteToShort(final String source) 	  { return "new Short((short) "+source+")";		}
	public static String fromintToShort(final String source) 	  { return "new Short((short) "+source+")";		}
	public static String fromlongToShort(final String source) 	  { return "new Short((short) "+source+")";		}
	public static String fromfloatToShort(final String source) 	  { return "new Short((short) "+source+")";		}
	public static String fromdoubleToShort(final String source)   { return "new Short((short) "+source+")";		}
	public static String fromcharToShort(final String source) 	  { return "new Short((short) "+source+")";		}
	public static String frombooleanToShort(final String source)  { return "new Short("+source+"?(short)1:(short)0)";   }
	
	public static String fromStringToShort(final String source)	  { return "new Short("+source+")";				}
	public static String fromByteToShort(final String source) 	  {	return "new Short("+source+".shortValue())";}
	public static String fromIntegerToShort(final String source)  {	return "new Short("+source+".shortValue())";}
	public static String fromLongToShort(final String source) 	  {	return "new Short("+source+".shortValue())";}
	public static String fromFloatToShort(final String source) 	  {	return "new Short("+source+".shortValue())";}
	public static String fromDoubleToShort(final String source)   {	return "new Short("+source+".shortValue())";}
	public static String fromCharacterToShort(final String source){	return "new Short((short)"+source+".charValue())";}
	public static String fromBooleanToShort(final String source)  { return "new Short("+source+".booleanValue()?(short)1:(short)0)";   }

	public static String frombyteToshort(final String source) 	  { return "(short) "+source;					}
	public static String fromintToshort(final String source) 	  { return "(short) "+source;					}
	public static String fromlongToshort(final String source) 	  { return "(short) "+source;					}
	public static String fromfloatToshort(final String source) 	  { return "(short) "+source;					}
	public static String fromdoubleToshort(final String source)   { return "(short) "+source;					}
	public static String fromcharToshort(final String source) 	  { return "(short) "+source;					}
	public static String frombooleanToshort(final String source)  { return source+"?(short)1:(short)0";   	    }
	
	public static String fromStringToshort(final String source)   { return "Short.parseShort("+source+")";		}
	public static String fromByteToshort(final String source) 	  { return source+".shortValue()";				}
	public static String fromIntegerToshort(final String source)  { return source+".shortValue()";				}
	public static String fromLongToshort(final String source) 	  { return source+".shortValue()";				}
	public static String fromFloatToshort(final String source) 	  { return source+".shortValue()";				}
	public static String fromDoubleToshort(final String source)   { return source+".shortValue()";				}
	public static String fromCharacterToshort(final String source){ return "(short) "+source+".charValue()";	}
	public static String fromBooleanToshort(final String source)  { return source+".booleanValue()?(short)1:(short)0";   }

	
	/*  INTEGER/INT METHODS  */
	public static String fromStringToInteger(final String source) { return "new Integer("+source+")";			}
	public static String frombyteToInteger(final String source)   { return "new Integer((int) "+source+")";		}
	public static String fromshortToInteger(final String source)  { return "new Integer((int) "+source+")";		}
	public static String fromlongToInteger(final String source)   { return "new Integer((int) "+source+")";		}
	public static String fromfloatToInteger(final String source)  { return "new Integer((int) "+source+")";		}
	public static String fromdoubleToInteger(final String source) { return "new Integer((int) "+source+")";		}
	public static String fromcharToInteger(final String source)   {	return "new Integer((int) "+source+")";		}
	public static String frombooleanToInteger(final String source){ return "new Integer("+source+"?(int)1:(int)0)";   }
	
	public static String fromByteToInteger(final String source)   {	return "new Integer("+source+".intValue())";}
	public static String fromShortToInteger(final String source)  {	return "new Integer("+source+".intValue())";}
	public static String fromLongToInteger(final String source)   {	return "new Integer("+source+".intValue())";}
	public static String fromFloatToInteger(final String source)  {	return "new Integer("+source+".intValue())";}
	public static String fromDoubleToInteger(final String source) {	return "new Integer("+source+".intValue())";}
	public static String fromCharacterToInteger(final String source){return "new Integer((int) "+source+".charValue())";}
	public static String fromBooleanToInteger(final String source){ return "new Integer("+source+".booleanValue()?(int)1:(int)0)";   }

	public static String frombyteToint(final String source)   	  { return "(int) "+source;						}
	public static String fromshortToint(final String source) 	  { return "(int) "+source;						}
	public static String fromlongToint(final String source) 	  { return "(int) "+source;						}
	public static String fromfloatToint(final String source) 	  { return "(int) "+source;						}
	public static String fromdoubleToint(final String source) 	  { return "(int) "+source;						}
	public static String fromcharToint(final String source) 	  { return "(int) "+source;						}
	public static String frombooleanToint(final String source)    { return source+"?(int)1:(int)0";   			}

	public static String fromStringToint(final String source) 	  { return "Integer.parseInt("+source+")";		}
	public static String fromByteToint(final String source) 	  { return source+".intValue()";				}
	public static String fromShortToint(final String source) 	  { return source+".intValue()";				}
	public static String fromLongToint(final String source) 	  { return source+".intValue()";				}
	public static String fromFloatToint(final String source) 	  { return source+".intValue()";				}
	public static String fromDoubleToint(final String source) 	  { return source+".intValue()";				}
	public static String fromCharacterToint(final String source)  { return "(int) "+source+".charValue()";		}
	public static String fromBooleanToint(final String source)    { return source+".booleanValue()?(int)1:(int)0";   }


	/*  LONG METHODS  */
	public static String fromStringToLong(final String source) 	  {	return "new Long("+source+")";				}
	public static String frombyteToLong(final String source)  	  { return "new Long((long) "+source+")";		}
	public static String fromshortToLong(final String source) 	  { return "new Long((long) "+source+")";		}
	public static String fromintToLong(final String source) 	  { return "new Long((long) "+source+")";		}
	public static String fromdoubleToLong(final String source) 	  { return "new Long((long) "+source+")";		}
	public static String fromcharToLong(final String source) 	  { return "new Long((long) "+source+")";		}
	public static String frombooleanToLong(final String source)	  { return "new Long("+source+"?1L:0L)";   		}

	public static String fromByteToLong(final String source) 	  {	return "new Long("+source+".longValue())";	}
	public static String fromShortToLong(final String source)	  {	return "new Long("+source+".longValue())";	}
	public static String fromIntegerToLong(final String source)   {	return "new Long("+source+".longValue())";	}
	public static String fromFloatToLong(final String source) 	  {	return "new Long("+source+".longValue())";	}
	public static String fromfloatToLong(final String source) 	  { return "new Long((long) "+source+")";		}
	public static String fromDoubleToLong(final String source) 	  {	return "new Long("+source+".longValue())";	}
	public static String fromCharacterToLong(final String source) { return "new Long((long) "+source+".charValue())";}
	public static String fromBooleanToLong(final String source)   { return "new Long("+source+".booleanValue()?1L:0L)";}
	
	public static String fromStringTolong(final String source) 	  { return "Long.parseLong("+source+")";		}
	public static String frombyteTolong(final String source) 	  { return "(long) "+source;					}
	public static String fromshortTolong(final String source) 	  { return "(long) "+source;					}
	public static String fromintTolong(final String source) 	  { return "(long) "+source;					}
	public static String fromfloatTolong(final String source) 	  { return "(long) "+source;					}
	public static String fromdoubleTolong(final String source) 	  { return "(long) "+source;					}
	public static String fromcharTolong(final String source) 	  { return "(long) "+source;					}
	public static String frombooleanTolong(final String source)   { return source+"?1L:0L";   					}

	public static String fromByteTolong(final String source) 	  { return source+".longValue()";				}
	public static String fromShortTolong(final String source) 	  { return source+".longValue()";				}
	public static String fromIntegerTolong(final String source)   { return source+".longValue()";				}
	public static String fromFloatTolong(final String source)     { return source+".longValue()";				}
	public static String fromDoubleTolong(final String source)    { return source+".longValue()";				}
	public static String fromCharacterTolong(final String source) { return "(long) "+source+".charValue()";		}
	public static String fromBooleanTolong(final String source)   { return source+".booleanValue()?1L:0L";   	}


	/*  FLOAT METHODS */
	public static String fromStringToFloat(final String source)   {	return "new Float("+source+")";				}
	public static String frombyteToFloat(final String source) 	  { return "new Float((float) "+source+")";		}
	public static String fromshortToFloat(final String source) 	  { return "new Float((float) "+source+")";		}
	public static String fromintToFloat(final String source) 	  { return "new Float((float) "+source+")";		}
	public static String fromlongToFloat(final String source) 	  { return "new Float((float) "+source+")";		}
	public static String fromdoubleToFloat(final String source)   { return "new Float((float) "+source+")";		}
	public static String fromcharToFloat(final String source) 	  { return "new Float((float) "+source+")";		}
	public static String frombooleanToFloat(final String source)  { return "new Float("+source+"?1F:0F)";		}
	
	public static String fromByteToFloat(final String source) 	  { return "new Float("+source+".floatValue())";}
	public static String fromShortToFloat(final String source) 	  { return "new Float("+source+".floatValue())";}
	public static String fromIntegerToFloat(final String source)  { return "new Float("+source+".floatValue())";}
	public static String fromLongToFloat(final String source) 	  { return "new Float("+source+".floatValue())";}
	public static String fromDoubleToFloat(final String source)   { return "new Float("+source+".floatValue())";}
	public static String fromCharacterToFloat(final String source){ return "new Float((float) "+source+".charValue())";}
	public static String fromBooleanToFloat(final String source)  { return "new Float("+source+".booleanValue()?1F:0F)";}

	public static String fromStringTofloat(final String source)	  { return "Float.parseFloat("+source+")";}
	public static String frombyteTofloat(final String source) 	  { return "(float) "+source;					}
	public static String fromshortTofloat(final String source) 	  { return "(float) "+source;					}
	public static String fromintTofloat(final String source) 	  { return "(float) "+source;					}
	public static String fromlongTofloat(final String source) 	  { return "(float) "+source;					}
	public static String fromdoubleTofloat(final String source)	  { return "(float) "+source;					}
	public static String fromcharTofloat(final String source) 	  { return "(float) "+source;					}
	public static String frombooleanTofloat(final String source)  { return source+"?1F:0F";}

	public static String fromByteTofloat(final String source) 	  { return source+".floatValue()";				}
	public static String fromShortTofloat(final String source)    { return source+".floatValue()";				}
	public static String fromIntegerTofloat(final String source)  { return source+".floatValue()";				}
	public static String fromLongTofloat(final String source) 	  { return source+".floatValue()";				}
	public static String fromDoubleTofloat(final String source)   { return source+".floatValue()";				}
	public static String fromCharacterTofloat(final String source){ return "(float) "+source+".charValue()";	}
	public static String fromBooleanTofloat(final String source)  { return source+".booleanValue()?1F:0F";		}


	/*  DOUBLE METHODS  */
	public static String fromStringToDouble(final String source)  {	return "new Double("+source+")";			}
	public static String frombyteToDouble(final String source) 	  {	return "new Double((double) "+source+")";	}
	public static String fromshortToDouble(final String source)   {	return "new Double((double) "+source+")";	}
	public static String fromintToDouble(final String source) 	  {	return "new Double((double) "+source+")";	}
	public static String fromlongToDouble(final String source) 	  {	return "new Double((double) "+source+")";	}
	public static String fromfloatToDouble(final String source)   {	return "new Double((double) "+source+")";	}
	public static String fromcharToDouble(final String source) 	  {	return "new Double((double) "+source+")";	}
	public static String frombooleanToDouble(final String source) { return "new Double("+source+"?1D:0D)";	    }

	public static String fromByteToDouble(final String source) 	  {	return "new Double("+source+".doubleValue())";}
	public static String fromShortToDouble(final String source)   {	return "new Double("+source+".doubleValue())";}
	public static String fromIntegerToDouble(final String source) {	return "new Double("+source+".doubleValue())";}
	public static String fromLongToDouble(final String source) 	  {	return "new Double("+source+".doubleValue())";}
	public static String fromFloatToDouble(final String source)   {	return "new Double("+source+".doubleValue())";}
	public static String fromCharacterToDouble(final String source){return "new Double((double) "+source+".charValue())";}
	public static String fromBooleanToDouble(final String source) { return "new Double("+source+".booleanValue()?1D:0D)";}
	
	public static String fromStringTodouble(final String source)  { return "Double.parseDouble("+source+")";	}
	public static String frombyteTodouble(final String source) 	  { return "(double) "+source;					}
	public static String fromshortTodouble(final String source)   { return "(double) "+source;					}
	public static String fromintTodouble(final String source) 	  { return "(double) "+source;					}
	public static String fromlongTodouble(final String source) 	  { return "(double) "+source;					}
	public static String fromfloatTodouble(final String source)   { return "(double) "+source;					}
	public static String fromcharTodouble(final String source) 	  { return "(double) "+source;					}
	public static String frombooleanTodouble(final String source) { return source+"?1D:0D";						}
	
	public static String fromLongTodouble(final String source) 	  { return source+".doubleValue()";				}
	public static String fromByteTodouble(final String source) 	  { return source+".doubleValue()";				}
	public static String fromShortTodouble(final String source)   { return source+".doubleValue()";				}
	public static String fromIntegerTodouble(final String source) { return source+".doubleValue()";				}
	public static String fromFloatTodouble(final String source)   { return source+".doubleValue()";				}
	public static String fromCharacterTodouble(final String source){return "(double) "+source+".charValue()";	}
	public static String fromBooleanTodouble(final String source)  {return source+".booleanValue()?1D:0D";		}
	
	
	/* CHARACTER/CHAR METHODS  */
	public static String fromStringToCharacter(final String source){ return "new Character("+source+".charAt(0))";}
	public static String frombyteToCharacter(final String source)  { return "new Character((char) "+source+")"; }
	public static String fromshortToCharacter(final String source) { return "new Character((char) "+source+")";	}
	public static String fromintToCharacter(final String source)   { return "new Character((char) "+source+")";	}
	public static String fromlongToCharacter(final String source)  { return "new Character((char) "+source+")";	}
	public static String fromfloatToCharacter(final String source) { return "new Character((char) "+source+")";	}
	public static String fromdoubleToCharacter(final String source){ return "new Character((char) "+source+")";	}
	public static String frombooleanToCharacter(final String source){return "new Character("+source+"?'T':'F')";}
	
	public static String fromByteToCharacter(final String source)  { return "new Character((char) "+source+".byteValue())";  }
	public static String fromShortToCharacter(final String source) { return "new Character((char) "+source+".shortValue())"; }
	public static String fromIntegerToCharacter(final String source){return "new Character((char) "+source+".intValue())";	 }
	public static String fromLongToCharacter(final String source)  { return "new Character((char) "+source+".longValue())";	 }
	public static String fromFloatToCharacter(final String source) { return "new Character((char) "+source+".floatValue())"; }
	public static String fromDoubleToCharacter(final String source){ return "new Character((char) "+source+".doubleValue())";}
	public static String fromBooleanToCharacter(final String source){return "new Character("+source+".booleanValue()?'T':'F')";}
	
	public static String fromStringTochar(final String source) 	  {return source+".charAt(0)";				    }
	public static String frombyteTochar(final String source) 	  {return "(char) "+source;						}
	public static String fromshortTochar(final String source) 	  {return "(char) "+source;						}
	public static String fromintTochar(final String source) 	  {return "(char) "+source;						}
	public static String fromlongTochar(final String source) 	  {return "(char) "+source;						}
	public static String fromfloatTochar(final String source) 	  {return "(char) "+source;						}
	public static String fromdoubleTochar(final String source) 	  {return "(char) "+source;						}
	public static String frombooleanTochar(final String source)   {return source+"?'T':'F'";					}
	
	public static String fromByteTochar(final String source) 	  {return "(char) "+source+".byteValue()";		}
	public static String fromShortTochar(final String source) 	  {return "(char) "+source+".shortValue()";		}
	public static String fromIntegerTochar(final String source)   {return "(char) "+source+".intValue()";		}
	public static String fromLongTochar(final String source) 	  {return "(char) "+source+".longValue()";		}
	public static String fromFloatTochar(final String source) 	  {return "(char) "+source+".floatValue()";		}
	public static String fromDoubleTochar(final String source) 	  {return "(char) "+source+".doubleValue()";	}
	public static String fromBooleanTochar(final String source)   {return source+".booleanValue()?'T':'F'";		}
	
	
	/*  BOOLEAN METHODS  */
	//TODO rivedere queste conversioni, usare Boolean.FALSE e Boolean.TRUE
	public static String fromStringToBoolean(final String source) { return "new Boolean("+source+")";			   }
	public static String frombyteToBoolean(final String source)   { return "new Boolean("+source+"==0?false:true)";}
	public static String fromshortToBoolean(final String source)  { return "new Boolean("+source+"==0?false:true)";}
	public static String fromintToBoolean(final String source) 	  { return "new Boolean("+source+"==0?false:true)";}
	public static String fromlongToBoolean(final String source)   { return "new Boolean("+source+"==0?false:true)";}
	public static String fromfloatToBoolean(final String source)  { return "new Boolean("+source+"==0?false:true)";}
	public static String fromdoubleToBoolean(final String source) { return "new Boolean("+source+"==0?false:true)";}
	public static String fromcharToBoolean(final String source)   { return "new Boolean("+source+"=='T'?true:"+source+"=='F'?false:null)";}
	
	public static String fromByteToBoolean(final String source)   { return "new Boolean("+source+".byteValue()==0?false:true)";}
	public static String fromShortToBoolean(final String source)  { return "new Boolean("+source+".shortValue()==0?false:true)";}
	public static String fromIntegerToBoolean(final String source){ return "new Boolean("+source+".intValue()==0?false:true)";}
	public static String fromLongToBoolean(final String source)	  { return "new Boolean("+source+".longValue()==0?false:true)";}
	public static String fromFloatToBoolean(final String source)  { return "new Boolean("+source+".floatValue()==0?false:true)";}
	public static String fromDoubleToBoolean(final String source) { return "new Boolean("+source+".doubleValue()==0?false:true)";}
	public static String fromCharacterToBoolean(final String source){ return "new Boolean("+source+".charValue()=='T'?true:"+source+".charValue()=='F'?false:null)";}
	
	public static String frombyteToboolean(final String source)   { return source+"==0?false:true";}
	public static String fromshortToboolean(final String source)  { return source+"==0?false:true";}
	public static String fromintToboolean(final String source) 	  { return source+"==0?false:true";}
	public static String fromlongToboolean(final String source)   { return source+"==0?false:true";}
	public static String fromfloatToboolean(final String source)  { return source+"==0?false:true";}
	public static String fromdoubleToboolean(final String source) { return source+"==0?false:true";}
	public static String fromcharToboolean(final String source)   { return source+"=='T'?true:false";}
	
	public static String fromStringToboolean(final String source) { return "Boolean.parseBoolean("+source+")";}
	public static String fromByteToboolean(final String source)   { return source+".byteValue()==0?false:true";}
	public static String fromShortToboolean(final String source)  { return source+".shortValue()==0?false:true";}
	public static String fromIntegerToboolean(final String source){ return source+".intValue()==0?false:true";}
	public static String fromLongToboolean(final String source)   { return source+".longValue()==0?false:true";}
	public static String fromFloatToboolean(final String source)  { return source+".floatValue()==0?false:true";}
	public static String fromDoubleToboolean(final String source) { return source+".doubleValue()==0?false:true";}
	public static String fromCharacterToboolean(final String source){ return source+".charValue()=='T'?true:false";}
}
