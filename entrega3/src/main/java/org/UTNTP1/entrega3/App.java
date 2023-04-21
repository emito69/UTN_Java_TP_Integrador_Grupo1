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
import java.util.HashSet;
import java.util.List;



public class App {

	public static void main(String[] args) {
				
		
		//String rutaResultados = args[0];
		
		//String rutaConfig = args[1];
		
		String rutaResultados = "C:\\Users\\alvar\\Downloads\\pruebas GIT UTN\\UTN_Java_TP_Integrador_Grupo1\\entrega3\\src\\main\\resources\\resultados.csv";//args[0]
			
		String rutaConfig = "C:\\Users\\alvar\\Downloads\\pruebas GIT UTN\\UTN_Java_TP_Integrador_Grupo1\\entrega3\\src\\main\\resources\\config.properties";//args[1]
			

		
			
		///// ******* 1- LECTURA DE LOS RESULTADOS ********************************************  //////
			
			LecturaFases lectorDefases = new LecturaFases(rutaResultados);	
						
			Fases estructuraDeFases = lectorDefases.armarFases();			
			
			/*for(int i=1; i < 2; i++) {
				String index = String.valueOf(i);
				System.out.println(" EMIIIII :" + estructuraDeFases.fase(index).ronda(index));
				
			}*/
					
			
			
		///// ******* 2- LECTURA DE PRONOSTICOS y CÁLCULO DE PUNTOS ********************************************************  ///////
				 
			try{
										
				//Lectura y disponibilización del Archivo de Configuración 
				new ConfigReader(rutaConfig);
				
	            // Llamado a Iniciar la Conexión         
				LecturaPronosticos lecturaProno= new LecturaPronosticos();			
						
				ArrayList<String> listaParticipantes= lecturaProno.obtenerListaDeParticipantes();
				HashSet<String> listaEquipos= lecturaProno.obtenerListaDeEquipos();
				
				/*
				for (String equipo : listaEquipos) {
					System.out.println(equipo);
				}
				*/
				
				//System.out.println("CANTIDAD DE PARTICIPANTES :" + listaParticipantes.size());
				//System.out.println("HASTA ACÁ LLEGÓ");
								
				for(String participante : listaParticipantes) {
								
					// System.out.println(participante);
					
					List<PronosticoObjetoParse> pronosticosParticipante = lecturaProno.obtenerPronosticosDeUnParticipante(participante);
					
					PuntosPronostico puntosParticipante = new PuntosPronostico(estructuraDeFases, pronosticosParticipante, listaEquipos);
							
							
					/*for (PronosticoObjetoParse p: pronosticosParticipante) {
						
						System.out.println(p.getIdFase() + " " + p.getIdRonda() + " " + p.getIdParticipante() + " " + p.getNombreParticipante() + " " + p.getNombreEquipo1() + " " + p.getGanaEquipo1() + " " + p.getEmpate() + " " + p.getGanaEquipo2() + " " + p.getNombreEquipo2());
					}*/
					
				}
				
	        }catch(IOException e){
	        	
				System.out.println("ERROR: No se pudo leer el archivo.");
				System.exit(1);
				 	
	        }catch(DBConnErrorException e) {
	        	
	        	System.out.println(e.getMessage());
	        	System.exit(1);
	        	
	        }
	     
	}
}

