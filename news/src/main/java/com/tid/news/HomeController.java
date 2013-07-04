package com.tid.news;

import java.text.DateFormat;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private Collection<Blog> blogs;
	private ArrayList<String> arraytitulos;
	private String urlString;
	private URL url;
	private Map<Integer, String> hash;
	private Blog blog;
	private SyndEntry entry;
	private int i;
	private int q;
	private int h;
	private int z=0;
	String [] palabrasSeparadas;
	String delimitadores;
	private Set<String> psclaves= new HashSet<String>();   
//	List <String> psclaves = new ArrayList <String>();
	private Set<String> psclaves2= new HashSet<String>();   
//	List <String> psclaves2 = new ArrayList <String>();
   
	//Set<String> s = new HashSet<String>();   
	/*Meter en el constructor las variables*/
	
	public HomeController() throws IllegalArgumentException, FeedException, IOException{
		logger.info("CONSTRUCTOR!!!!!.");
		blogs = new ArrayList<Blog>();
		arraytitulos = new ArrayList<String>();
		//urlString = "http://ep00.epimg.net/rss/elpais/portada.xml";
		urlString = "http://estaticos.elmundo.es/elmundo/rss/portada.xml";
		url = new URL(urlString);
		
		HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(httpcon));
		List entries = feed.getEntries();
		Iterator itEntries = entries.iterator();
		hash = new HashMap<Integer, String>();
		int i=0;
		/*Crear otro recurso REST que te devuelva la fecha*/
		while (itEntries.hasNext()) {
			entry = (SyndEntry) itEntries.next();
			//Crear un array e ir cogiendo todos los títulos para enviarlo a la vista y mostrarlos allí.
		//	entry.getPublishedDate()
			String o = entry.getDescription().getValue();
			logger.debug(o.toString());
			
			String descripcion=entry.getDescription().getValue();
			
			String titulo=entry.getTitle();
			
			blog = new Blog(i++, titulo, descripcion);
			hash.put(i, entry.getPublishedDate().toString());
			//hash.get(entry.getTitle());
            blogs.add(blog);
            
        //Separar palabras
           
            delimitadores= "[ .,;?!¡¿\'\"\\[\\]]+";
                                  	
            String [] palabrasSeparadas = titulo.split(delimitadores);
            String [] palabrasSeparadas2 = descripcion.split(delimitadores);
            
//            Iterator <String> it = psclaves.iterator(); 
//            
//            while (it.hasNext()){
//            	
//            	
//            }
//     
            
//            for(String palabrasSeparada: palabrasSeparadas){
//            	
//            }
            
   //palabras destacadas de los títulos 
            
          for(i=0; i<palabrasSeparadas.length; i++){
        	int longitud = palabrasSeparadas[i].length();
        	  if(longitud >= 5){
        		           
                	//  if(palabrasSeparadas[i].equals(psclaves.get(h))){
                		  //hola 
  	                 	  
                	  		psclaves.add(palabrasSeparadas[i]);

        	}
        } 
          
    //
          
   //palabras destacadas de las noticias    
         
          for(q=0; q<palabrasSeparadas2.length; q++){
          	int longitud2 = palabrasSeparadas2[q].length();
          	  if(longitud2 >= 5){
          		psclaves2.add(palabrasSeparadas2[q]);
             //  logger.info(psclaves.get(z));              
             //  z++; 
          		
          	}
          }  
	}
}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws IllegalArgumentException, MalformedURLException, FeedException, IOException {
		logger.info("Welcome home! The client locale is {}.", locale);
			
            model.addAttribute("blogs", blogs );
        
			//palabras clave
         
            model.addAttribute("psclaves", psclaves );
            model.addAttribute("psclaves2", psclaves2 );
            return "home";           
		}
		 
}	