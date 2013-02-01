/**
 * Copyright (C) 2012 - 2013 Alessandro Vurro.
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

import static com.googlecode.jmapper.generation.MapperBuilder.from;
import com.googlecode.jmapper.config.Error;
import com.googlecode.jmapper.config.JmapperLog;
import com.googlecode.jmapper.enums.ChooseConfig;
import com.googlecode.jmapper.enums.MappingType;
import com.googlecode.jmapper.enums.NullPointerControl;
import com.googlecode.jmapper.generation.MapperBuilder;
import javassist.NotFoundException;

/*  Global Mapping 
  
       In some cases we have the need to map two fields with the same name or several fields toward the same field.
       Currently the only mode to do this is configure each field creating much redundance. 
       To avoid it, will be introduced the global mapping.
        
  		ANNOTATION
       
           The annotation to use is @JGlobalMap, it has the same parameters of @JMap with more one: excluded, with is 
           we can exclude the fields which do not fall in this mapping.
           
           First example
           
           Old configuration:
       	class Esempio {
           
               @JMap("properties") 
               String field1;
               @JMap("properties") 
               String field2;
               
               String field3;
               ...
               
               //getters and setters
           }
           
       	New configuration:
       	@JGlobalMap(value="properties",excluded={"field3"})
       	class Esempio {
           
               String field1;
               String field2;
               String field3;
               ...
               
               //getters and setters
           }
  
           Second example:
           
           Old configuration:
       	class Esempio {
           
               @JMap String field1;
               @JMap String field2;
                     String field3;
               ...
               
               //getters and setters
           }
           
       	New configuration:
       	@JGlobalMap(excluded={"field3"})
       	class Esempio {
           
               String field1;
               String field2;
               String field3;
               ...
               
               //getters and setters
           }
           
           @JGlobalMap has greater visibility of @JMap, 
           if a field is not configured with @JGlobalMap JMapper checks if it is configured with @JMap.
           
           For example:
           
       	@JGlobalMap(excluded={"field3"})
       	class Esempio {
           
               String field1;
               String field2;
               @JMap("other")String field3;
               ...
               
               //getters and setters
           }          
       
       	XML
       
           The tag to use is:
           
  			<global/>	
  
           it has the same structure of attribute node, but without the attribute name.
           it has a more node: "excluded". Considering the class written in advance:
           
           First example:
           
           Old version:
           <jmapper>
              <class name="className">
                 <attribute name = "field1">
                    <value name = "field1"/>
                 </attribute>
                 <attribute name = "field2">
                    <value name = "field2"/>
                 </attribute>
              </class>
           </jmapper>
           
           New version:
           <jmapper>
              <class name="className">
                 <global>
                    <excluded>
  				        <attribute name ="field3" />
  			         </excluded>
                 </global>
              </class>
           </jmapper>
           
           Second example:
           
           Old version:
           <jmapper>
              <class name="className">
                 <attribute name = "field1">
                    <value name = "properties"/>
                 </attribute>
                 <attribute name = "field2">
                    <value name = "properties"/>
                 </attribute>
              </class>
           </jmapper>
           
           New version:
           <jmapper>
              <class name="className">
                 <global>
                    <value name = "properties"/>
                    <excluded>
  				        <attribute name = "field3" />
  			         </excluded>
                 </global>
              </class>
           </jmapper>
           
           <global> has greater visibility of <attribute>, 
           if a field is not configured with <global> JMapper checks if it is configured with <attribute>.
           
           For example:
           
           <jmapper>
              <class name="className">
                 <global>
                    <value name = "properties"/>
                    <excluded>
  				        <attribute name = "field3" />
  			         </excluded>
                 </global>
                 <attribute name = "field3">
                    <value name = "other"/>
                 </attribute>
              </class>
           </jmapper>
           
 * */

/*       REFACTORING del codice
 * 
 *        gestire gli analyzer in un vettore e non con una sequenza di if.
 *        ottimizzare il codice generato, ad es: pre-decremento degli indici (--i) invece del post (i--)
 * 
 * */

/*
 *  Multiple Mapping
 *  
 *  	Con la classe RelationalJMapper si ha la possibilità di implementare una relazione 1 a N o N a 1 tra
 *      la classe configurata e quelle target.
 *      Ma la relazione che c'è tra i campi della classe configurata e i campi delle classi target è sempre 1 a 1.
 *      Ciò vuol dire che in caso di conversioni dinamiche non è permesso (con la versione 1.1.0) configurare 
 *      direttamente un campo con N altri, ma invece bisogna configurare gli N campi verso il campo interessato.
 *      
 *      Quindi abbiamo potenzialmente due situazioni: 
 *      - la seconda in cui 1 campo deve rapportarsi con N campis
 * 
 
 *      CASO
 *      
 *          L'intento è quello di configurare 1 campo verso N altri, questo ha senso solo in caso di conversione dinamica
 *          
 *          ANNOTATION
 *          
 *      	class Esempio {
 *          
 *              @JMultiMap(targetClass=Target.class,attributes={"field1","field2","field3"}) 
 *              String field1;
 *              ...
 *          }
 *          
 *          @JMultiMap permette di configurare un campo contemporaneamente con N altri. Omettendo la targetClass si indica
 *          al framework di considerare quella in input al costruttore, omettendo gli attributes si indica al framework che
 *          tutti i campi della classe target sono coinvolti.
 *          Nel caso in cui ci sia l'esigenza di dichiarare il multimapping verso altri campi di altre classi basterà
 *          usare l'annotation @JMultiMaps es:
 *          
 *      	class Esempio {
 *          
 *              @JMultiMaps({
 *                  @JMultiMap(targetClass=Target.class,attributes={"field1","field2","field3"})
 *                  @JMultiMap(targetClass=Other.class, attributes={"other1","other2","other3"})
 *              }) 
 *              String field1;
 *              ...
 *          }
 *          
 *          XML
 *          
 *          Per esprimere lo stesso concetto in xml si utilizzerà il nodo multiAttribute, es:
 *          
 * 			<multiAttribute name="">
 *    			<target class="com.myapplication.Target" attributes="field1,field2,field3" />
 * 			</multiAttribute>
 * 
 *          multiAttribute ha un attributo name che corrisponde al nome del campo configurato e N nodi target,
 *          il nodo target rispecchia l'annotation @JMultiMap, ovvero ha un attributo class e un attributo attributes,
 *          che contiene la lista dei campi separati da una virgola.
 *          Per riflettere invece JMultiMaps basterà dichiarare piu nodi target. 
 *          
 *          
 * */


/* 
 *
 *  CONFIGURATIONS
 *  
 *  configurations permette di definire delle configurazioni ad hoc per il campo, o per l'intera classe.
 *  configurations è un parametro che sarà aggiunto all'annotation JMap (per la configurazione del campo)
 *  e all'annotation JGlobalMap (per la configurazione di tutti i campi contemporaneamente)
 *    
 *    public @interface JMap {
 *	     ...
 *       Configuration[] configurations() default {};
 *       ...
 *    }
 * 
 * in xml, in aggiunta ai nodi attribute e global:
 *    
 *    ...
 *    <configurations name="TO_COPY, FLATTERN"/>
 *    ...
 *    
 * Configuration è una enumeration che ha i seguenti valori: 
 *  - NOT_ACCUMULATIVE, in caso di collection o map piene, la destinazione deve
 *                      acquisire i valori del source senza sommarli.
 *  - TO_COPY, in caso non si voglia lavorare per riferimento ma per copia
 *  - NEW_INSTANCE nel caso in cui una delle istanze in input sono nulle ritornare una nuova istanza della classe
 *                 di destinazione
 *  - FLATTERN nel caso in cui i nomi dei campi sono identici ma a livelli diversi, permette di applicare automaticamente
 *             il mapping
 * 
 * esempio di utilizzo dell'annotation:
 * 
 * @JMap(Configuration.TO_COPY) 
 * 
 *  oppure
 *   
 * @JMap(configurations={TO_COPY,FLATTERN})
 * */


/*
 *  DEFAULT BEHAVIORs
 * 
 *  i comportamenti predefiniti tornano utili in tutti quei casi in cui il comportamento è lo stesso in tutti i casi
 *  in cui può verificarsi, come ad esempio la conversione da stringhe a date: in questo modo possiamo centralizzare
 *  la conversione in un unico metodo.
 *  
 *  @DefaultBehavior
 *  class DateBehaviors {
 *  
 *     @Creation
 *     public static Date getDate(String str){
 *        return new java.text.SimpleDateFormat("dd/MM/yyyy").parse(str);
 *     }
 *     
 *     @Enrichment
 *     public static void enrichDate(Date date, String str){
 *        date = new java.text.SimpleDateFormat("dd/MM/yyyy").parse(str);
 *     }
 *  }
 *  
 *  Oppure quando il campo di destinazione è una lista e i campi sorgenti sono oggetti: in questo caso il 
 *  comportamento predefinito consisterebbe nel effettuare diversi add.
 *  
 *  @DefaultBehavior
 *  class ListBehaviors {
 *  
 *     @Creation
 *     public static <T> List<T> getList(T str){
 *        List<T> list = new ArrayList<T>();
 *        list.add(str);
 *        return list;
 *     }
 * 
 *     @Enrichment
 *     public static <T> void enrichList(List<T> list, T str){
 *        list.add(str);
 *     }
 *  }
 * 
 *  Lo stesso criterio lo si può usare quando ad essere configurati sono un StringBuilder/StringBuffer con diverse stringhe.
 * 
 *  @DefaultBehaviors
 *  class ListBehaviors {
 *  
 *     @Creation
 *     public static StringBuilder getSb(Object obj){
 *       return new StringBuilder(obj);
 *     }
 *     
 *     @Enrichment
 *     public static void enrichSb(StringBuilder sb, Object str){
 *        sb.append(obj);
 *     }
 *  }
 * 
 *  Così facendo basterà configurare i campi senza esplicite conversioni.
 *  
 *  Per usufruire di questa feature bisogna contrassegnare la classe con l'annotation @DefaultBehaviors
 *  e contrassegnare i metodi che creano il destination con @Creation e quelli che lo arricchiscono con @Enrichment
 * */

//TODO implementare --> mapping con dislivello es: complexObj.name -> info 
//TODO implementare --> mapping sfruttando il regex 
//TODO implementare --> possibilità di definire il template
//TODO implementare --> custom accessor: dare la possibilità di definire il get e il set del campo

/**
 * JMapper takes as input two classes, Destination and Source.<br>
 * For Destination, we mean the instance that will be created or enhanced.<br>
 * For Source, we mean the instance containing the data.<br>
 * To execute the mapping, we must before configure one class between Destination and Source.<br><br>
 * for example:
 * <pre><code>
 * class Destination {
 * 
 *  {@code @JMap}
 *  String id;
 * 
 *  {@code @JMap("sourceField")}
 *  String destinationField;
 *  
 *  String other;
 *  
 *  // getter and setter
 * }
 * 
 * class Source {
 * 
 *  String id;
 * 
 *  String sourceField;
 *  
 *  String other;
 *  
 *  // getter and setter
 * }
 * </code></pre>
 * then invoke the method GetDestination.<br><br>
 * For example:
 * <pre><code>	
 * Source source = new Source("id", "sourceField", "other");
 * JMapper<Destination,Source> jmapper = new JMapper<Destination,Source>(Destination.class, Source.class);
 * // new instance
 * Destination destination = jmapper.getDestination(source); 
 * // enrichment
 * jmapper.getDestination(destination, source);</code></pre>
 * @author Alessandro Vurro
 * @param <D> Type of the Destination Class
 * @param <S> Type of Source Class
 */
public final class JMapper<D,S> implements IJMapper<D, S>{
	
	/** mapper that contains all mapping combination */
	private IMapper<D,S> mapper;
	
	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param source instance that contains the data
	 * @return new instance of destination
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(final S source){
		return mapper.nullVSouAllAll(source);
	}
	
	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param source instance that contains the data
	 * @return new instance of destination
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestinationWithoutControl(final S source){
		return mapper.nullVNotAllAll(source);
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>ALL</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(D destination,final S source){
		return mapper.vVAllAllAll(destination,source); 
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>NOT_ANY</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td><code>ALL_FIELDS<code></td>
	 * </tr>
	 * </table>
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestinationWithoutControl(D destination,final S source){
		return mapper.vVNotAllAll(destination,source); 
	}
		
	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>SOURCE</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param source instance that contains the data
	 * @param mtSource type of mapping
	 * @return new instance of destination
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(final S source,final MappingType mtSource){
		return getDestination(source,NullPointerControl.SOURCE,mtSource);
	}
	
	/**
	 * This method returns a new instance of Destination Class with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td>nullPointerControl</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td><code>ALL_FIELDS<code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param source instance that contains the data
	 * @param nullPointerControl type of control
	 * @param mtSource type of mapping
	 * @return new instance of destination
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(final S source,final NullPointerControl nullPointerControl,final MappingType mtSource){
		switch(nullPointerControl){
			case ALL:
			case DESTINATION:
			case SOURCE:	switch(mtSource){
							case ALL_FIELDS: 			return mapper.nullVSouAllAll(source); 
							case ONLY_VALUED_FIELDS:	return mapper.nullVSouAllValued(source);
							case ONLY_NULL_FIELDS:		return mapper.get(source);}
			case NOT_ANY:	switch(mtSource){
							case ALL_FIELDS: 			return mapper.nullVNotAllAll(source); 
							case ONLY_VALUED_FIELDS:	return mapper.nullVNotAllValued(source);
							case ONLY_NULL_FIELDS:		return mapper.get(source);}}
		return null;
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td><code>ALL</code></td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td>mtDestination</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @param mtDestination type of mapping of destination instance
	 * @param mtSource type of mapping of source instance 
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(D destination,final S source,final MappingType mtDestination,final MappingType mtSource){
			return getDestination(destination,source,NullPointerControl.ALL,mtDestination,mtSource);
	}
	
	/**
	 * This Method returns the destination given in input enriched with data contained in source given in input<br>
	 * with this setting:
	 * <table>
	 * <tr>
	 * <td><code>NullPointerControl</code></td><td>nullPointerControl</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Destination</td><td>mtDestination</td>
	 * </tr><tr>
	 * <td><code>MappingType</code> of Source</td><td>mtSource</td>
	 * </tr>
	 * </table>
	 * @param destination instance to enrich
	 * @param source instance that contains the data
	 * @param nullPointerControl type of control
	 * @param mtDestination type of mapping of destination instance
	 * @param mtSource type of mapping of source instance 
	 * @return destination enriched
	 * @see NullPointerControl
	 * @see MappingType
	 */
	public D getDestination(D destination,final S source,final NullPointerControl nullPointerControl,final MappingType mtDestination,final MappingType mtSource){
		switch(nullPointerControl){
		case ALL:			switch(mtDestination){
							case ALL_FIELDS: 			switch(mtSource){
														case ALL_FIELDS:  			return mapper.vVAllAllAll(destination,source); 
														case ONLY_VALUED_FIELDS:	return mapper.vVAllAllValued(destination,source); 
														case ONLY_NULL_FIELDS:		return mapper.vVAllValuedNull(destination,source); }
							case ONLY_VALUED_FIELDS: 	switch(mtSource){
														case ALL_FIELDS: 			return mapper.vVAllValuedAll(destination,source); 
														case ONLY_VALUED_FIELDS: 	return mapper.vVAllValuedValued(destination,source); 
														case ONLY_NULL_FIELDS:		return mapper.vVAllValuedNull(destination,source); } 
							case ONLY_NULL_FIELDS:		switch(mtSource){
														case ALL_FIELDS:			
														case ONLY_VALUED_FIELDS: 	return mapper.vVAllNullValued(destination,source); 
														case ONLY_NULL_FIELDS:		return destination;}}
		case DESTINATION: 	switch(mtDestination){
							case ALL_FIELDS: 			switch(mtSource){
														case ALL_FIELDS: 			return mapper.vVDesAllAll(destination,source); 
														case ONLY_VALUED_FIELDS: 	return mapper.vVDesAllValued(destination,source); 
														case ONLY_NULL_FIELDS:		return mapper.vVDesValuedNull(destination,source); }
							case ONLY_VALUED_FIELDS: 	switch(mtSource){
														case ALL_FIELDS: 			return mapper.vVDesValuedAll(destination,source); 
														case ONLY_VALUED_FIELDS: 	return mapper.vVDesValuedValued(destination,source); 
														case ONLY_NULL_FIELDS:		return mapper.vVDesValuedNull(destination,source); }
							case ONLY_NULL_FIELDS:		switch(mtSource){
														case ALL_FIELDS: 
														case ONLY_VALUED_FIELDS: 	return mapper.vVDesNullValued(destination,source); 
														case ONLY_NULL_FIELDS:		return destination;}}
		case SOURCE: 		switch(mtDestination){
							case ALL_FIELDS: 			switch(mtSource){
														case ALL_FIELDS: 			return mapper.vVSouAllAll(destination,source); 
														case ONLY_VALUED_FIELDS: 	return mapper.vVSouAllValued(destination,source); 
														case ONLY_NULL_FIELDS:		return mapper.vVSouValuedNull(destination,source); }
							case ONLY_VALUED_FIELDS: 	switch(mtSource){
														case ALL_FIELDS: 			return mapper.vVSouValuedAll(destination,source); 
														case ONLY_VALUED_FIELDS: 	return mapper.vVSouValuedValued(destination,source); 
														case ONLY_NULL_FIELDS:		return mapper.vVSouValuedNull(destination,source); }
							case ONLY_NULL_FIELDS:		switch(mtSource){
														case ALL_FIELDS: 
														case ONLY_VALUED_FIELDS: 	return mapper.vVSouNullValued(destination,source); 
														case ONLY_NULL_FIELDS:		return destination;}}
		case NOT_ANY:		switch(mtDestination){
							case ALL_FIELDS: 			switch(mtSource){
														case ALL_FIELDS: 			return mapper.vVNotAllAll(destination,source); 
														case ONLY_VALUED_FIELDS: 	return mapper.vVNotAllValued(destination,source); 
														case ONLY_NULL_FIELDS:		return mapper.vVNotValuedNull(destination,source); }
							case ONLY_VALUED_FIELDS: 	switch(mtSource){
														case ALL_FIELDS: 			return mapper.vVNotValuedAll(destination,source); 
														case ONLY_VALUED_FIELDS: 	return mapper.vVNotValuedValued(destination,source); 
														case ONLY_NULL_FIELDS:		return mapper.vVNotValuedNull(destination,source); }
							case ONLY_NULL_FIELDS:		switch(mtSource){
														case ALL_FIELDS: 
														case ONLY_VALUED_FIELDS: 	return mapper.vVNotNullValued(destination,source); 
														case ONLY_NULL_FIELDS:		return destination;}}
		}
		return null;
	}
	
	/**
	 * Constructs a JMapper that handles two classes: the class of destination and the class of source.
	 * <br>Configuration will be searched automatically.
	 * 
	 * @param destination the Destination Class
	 * @param source the Source Class
	 */
	public JMapper(final Class<D> destination,final  Class<S> source) {
		this(destination,source,null,null);
	}
	
	/**
	 * Constructs a JMapper that handles two classes: the class of destination and the class of source.
	 * <br>The configuration evaluated is the one received in input.
	 *  
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param chooseConfig the configuration to load
	 * @see ChooseConfig
	 */
	public JMapper(final Class<D> destination,final Class<S> source,final ChooseConfig chooseConfig) {
		this(destination,source,chooseConfig,null);
	}
	
	/**
	 * Constructs a JMapper that handles two classes: the class of destination and the class of source.
	 * <br>Taking as input the path to the xml file.
	 *  
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param xmlPath xml configuration path
	 * @see ChooseConfig
	 */
	public JMapper(final Class<D> destination,final Class<S> source,final String xmlPath) {
		this(destination,source,null,xmlPath);
	}
	
	/**
	 * Constructs a JMapper that handles two classes: the class of destination and the class of source.
	 * <br>The configuration evaluated is the one received in input present in the xml configuration file.
	 *  
	 * @param destination the Destination Class
	 * @param source the Source Class
	 * @param config the configuration to load
	 * @param xmlPath xml configuration path
	 * @see ChooseConfig
	 */
	public  JMapper(final Class<D> destination,final Class<S> source,final ChooseConfig config,final String xmlPath) {
		try{
			if(destination == null) 	  Error.nullMappedClass("Destination");
			if(source == null)            Error.nullMappedClass("Source");
			if(destination.isInterface()) Error.interfaceClass("Destination");
			if(source.isInterface()) 	  Error.interfaceClass("Source");
			
			try{	             		  destination.newInstance();	            }
			catch (Exception e){ 	      Error.emptyConstructorAbsent(destination);}
			
			this.mapper = createMapper(from(source).to(destination)
					                        .analyzing(config)
					                        .presentIn(xmlPath));  
			
		}catch (Exception e) { JmapperLog.ERROR(e); }
	}
	
    public IMapper<D,S> createMapper(MapperBuilder mapper) throws NotFoundException, Exception{
	    
		Class<IMapper<D,S>> mapperClass = mapper.exist()?mapper.<D,S>get()
				                                        :mapper.<D,S>generate();
		return mapperClass.newInstance();
	}
}