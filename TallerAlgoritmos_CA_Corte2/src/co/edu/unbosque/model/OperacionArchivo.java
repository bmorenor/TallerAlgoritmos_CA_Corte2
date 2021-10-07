package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.sun.source.tree.CatchTree;
/**
 * OperacionArchivo es una clase usada para leer archivos
 * @author Andres
 *
 */
public class OperacionArchivo {


	/**
	 * Es el constructor de la clase (no parametros)
	 */
	
	public OperacionArchivo () {
		
	}
	
	/**
	 * Este método lee el archivo 
	 * @param ruta: dirección del archivo
	 * @return String: contenido del archivo
	 */
	public String leerArchivo (String ruta) {
		 File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
String contenido = "";
	      
	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File (ruta);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null)
	        	 contenido = contenido + linea + "\n";
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	return contenido;
	}

}
