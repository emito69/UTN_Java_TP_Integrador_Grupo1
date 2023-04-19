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
			

			///// ******* PRONOSTICOS **************************************  ///////	
			
			LecturaFases lectorDefases = new LecturaFases(rutaResultados);	
						
			Fases estructuraDeFases = lectorDefases.armarFases();			
			
			/*for(int i=0; i > lectorDefases.getCantPartidos(); i++) {
								
			//	estructuraDeFases.
				
			}*/
			///// ***************************  ///////	
			
			
			
			
			///// ******* RESULTADOS ********************************************  /////// 
				 
			try{
										
				//Lectura y disponibilización del Archivo de Configuración 
				new ConfigReader(rutaConfig);
				
				System.out.println("");
	            System.out.println("conectando a la base de datos...");
	            
	            // Llamado a Iniciar la Conexión
				LecturaPronosticos lecturaProno= new LecturaPronosticos();			
							
				ArrayList<String> listaParticipantes= lecturaProno.obtenerListaDeParticipantes();
				
				System.out.println("CANTIDAD DE PARTICIPANTES :" + listaParticipantes.size());
				//System.out.println("HASTA ACÁ LLEGÓ");
				//System.out.println("HASTA ACÁ LLEGÓ");
				
				for(String participante : listaParticipantes) {
								
					System.out.println(participante);
					
					List<PronosticoObjetoParse> pronosticosParticipante = lecturaProno.obtenerPronosticosDeUnParticipante(participante);
					System.out.println("HASTA ACÁ LLEGÓ");
					for (PronosticoObjetoParse p: pronosticosParticipante) {
						
						System.out.println(p.getIdFase() + " " + p.getIdRonda() + " " + p.getIdParticipante() + " " + p.getNombreParticipante() + " " + p.getNombreEquipo1() + " " + p.getGanaEquipo1() + " " + p.getEmpate() + " " + p.getGanaEquipo2() + " " + p.getNombreEquipo2());
					}
				}
				
			///// ***************************  ///////	 
				
				
				
				
	        }catch(IOException e){
	        	
				System.out.println("ERROR: No se pudo leer el archivo.");
				System.exit(1);
				 	
	        }catch(DBConnErrorException e) {
	        	
	        	System.out.println(e.getMessage());
	        	System.exit(1);
	        	
	        }
	        
	        ///// ***********************  ///////
	        
	        

	}
}

