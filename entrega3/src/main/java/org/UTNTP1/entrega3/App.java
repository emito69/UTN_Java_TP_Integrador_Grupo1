package org.UTNTP1.entrega3;

import org.UTNTP1.entrega3.models.*;

import org.UTNTP1.entrega3.services.*;

import java.io.IOException;

import org.UTNTP1.entrega3.config.ConfigReader;
import org.UTNTP1.entrega3.exceptions.CantidadDeGolesEnterosException;
import org.UTNTP1.entrega3.exceptions.DBConnErrorException;
import org.UTNTP1.entrega3.exceptions.NumeroCorrectoDeCamposException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;



public class App {

	public static void main(String[] args) {
		
		
		
			//String rutaAbsoluta1 = "C:\\Users\\alvar\\Documents\\EclipseProjects\\entrega1\\src\\main\\java\\org\\UTNTP1\\entrega1\\archivos\\resultados.csv";
			//String rutaAbsoluta2 = "C:\\Users\\alvar\\Documents\\EclipseProjects\\entrega1\\src\\main\\java\\org\\UTNTP1\\entrega1\\archivos\\pronostico.csv";
			
			
			String rutaResultados = "C:\\Users\\alvar\\Downloads\\pruebas GIT UTN\\UTN_Java_TP_Integrador_Grupo1\\entrega3\\src\\main\\resources\\resultados.csv";//args[0]
			
			String rutaConfig = "C:\\Users\\alvar\\Downloads\\pruebas GIT UTN\\UTN_Java_TP_Integrador_Grupo1\\entrega3\\src\\main\\resources\\config.properties";//args[1]
			

			
			try{
	            
				///// ***** RESULTADOS *****  /////// 
				
				
				LecturaResultados lecturaResul= new LecturaResultados(rutaResultados);	
				
				List<ResultadoObjetoParse> listita1 = lecturaResul.leerCSVResultados();
				
				for(ResultadoObjetoParse result : listita1) {
					System.out.println(result.getNombreEquipo1());	
				}
				
				
								
				///// ***** PRONOSTICOS *****  /////// 
				
				//Lectura y disponibilización del Archivo de Configuración 
				new ConfigReader(rutaConfig);
								
				
				System.out.println("");
	            System.out.println("conectando a la base de datos...");
	            
	            // Llamado a Iniciar la Conexión
				LecturaPronosticos lecturaProno= new LecturaPronosticos();			
				
				lecturaProno.cargarPronosticos();
				
				List<PronosticoObjetoParse> listita2 = lecturaProno.getListaDePronosticosParseados();
				
				for(PronosticoObjetoParse prono : listita2) {
					System.out.println(prono.getIdParticipante());	
				}
				
				System.out.println("Cantidad de Participantes: "+lecturaProno.obtenerCantParticipantes());

				///// ***** ************** *****  /////// 
				
				
				
				
	        }catch(IOException e){
	        	
				System.out.println("ERROR: No se pudo leer el archivo.");
				System.exit(1);
				 	
	        }catch(DBConnErrorException e) {
	        	
	        	System.out.println(e.getMessage());
	        	System.exit(1);
	        	
	        }catch(CantidadDeGolesEnterosException e) {
	        	
	        	System.out.println(e.getMessage());
	        	System.exit(1);
	        	
	        }catch(NumeroCorrectoDeCamposException e) {
	        	
	        	System.out.println(e.getMessage());
	        	System.exit(1);
	        }

	}
}

