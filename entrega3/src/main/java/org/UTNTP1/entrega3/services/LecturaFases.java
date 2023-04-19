package org.UTNTP1.entrega3.services;

import org.UTNTP1.entrega3.models.*;

import java.io.IOException;

import org.UTNTP1.entrega3.config.ConfigReader;
import org.UTNTP1.entrega3.exceptions.CantidadDeGolesEnterosException;
import org.UTNTP1.entrega3.exceptions.DBConnErrorException;
import org.UTNTP1.entrega3.exceptions.NumeroCorrectoDeCamposException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LecturaFases {
	
	private int cantPartidos = 0;
	private String rutaResultados;	
	private Fases estructuraDeFases;
	
	// CONSTRUCTOR	
	public LecturaFases (String rutaResultados) {
		
		this.rutaResultados = rutaResultados;
		this.estructuraDeFases = new Fases();
	}
	
	
	// Método Armado de ESTRUCTURA FASES/RONDA/PARTIDOS   **********/
	public Fases armarFases() {
				
		try{

			//Fases estructuraDeFases = new Fases();
			
			LecturaResultados lecturaResul= new LecturaResultados(rutaResultados);	
			
			List<ResultadoObjetoParse> listaConResultados = lecturaResul.leerCSVResultados();
			
			/*for(ResultadoObjetoParse result : listaConResultados) {
				System.out.println(result.getIdEquipo1());	
			}*/
									
			
			// System.out.println("LLEGUÉ HASTA AQUÍ");
			
			
			if (listaConResultados.size()>0) {
				 
				for(ResultadoObjetoParse eachFase : listaConResultados) {
				
					//System.out.println(estructuraDeFases.size());
					//System.out.println(Integer.parseInt(result.getIdFase()));	
					
					// AGREGAMOS LAS Fases A LA ESTRUCTURA //
					if(estructuraDeFases.size() < Integer.parseInt(eachFase.getIdFase())) { 
						
						estructuraDeFases.add(new Fase(eachFase.getIdFase()));
					
						System.out.println("ID: FASE:" + estructuraDeFases.fase(eachFase.getIdFase()).nro());	

						for(ResultadoObjetoParse eachRonda : listaConResultados) {
								
							// AGREGAMOS LAS Rondas A LA ESTRUCTURA //
							if(estructuraDeFases.fase(eachRonda.getIdFase()).size() < Integer.parseInt(eachRonda.getIdRonda())) {
								
								estructuraDeFases.fase(eachRonda.getIdFase()).add(new Ronda(eachRonda.getIdRonda()));
								
								System.out.println("ID: RONDA:" + estructuraDeFases.fase(eachRonda.getIdFase())
								.ronda(eachRonda.getIdRonda()).nro());	
								
							}
							
						}

					}
					
				}
	
				
				// AGREGAMOS TODOS LOS PARIDOS
				
				for(ResultadoObjetoParse eachPartido : listaConResultados) {

					
					// AGREGAMOS LOS Partidos A LA ESTRUCTURA //
					// ayuda constructor Partido: Partido(equipo1, equipo2, golesEquipo1, golesEquipo2) 
	                // ayuda constructor Equipo: Equipo (int Id, String nombre, String descripcion)
					
					estructuraDeFases.fase(eachPartido.getIdFase())
					 .ronda(eachPartido.getIdRonda())
					 .add(new Partido(
							new Equipo(Integer.parseInt(eachPartido.getIdEquipo1()), eachPartido.getNombreEquipo1(), eachPartido.getDescripcionEquipo1()),
							new Equipo(Integer.parseInt(eachPartido.getIdEquipo1()), eachPartido.getNombreEquipo1(), eachPartido.getDescripcionEquipo1()),
							Integer.parseInt(eachPartido.getGolesEquipo1()),
							Integer.parseInt(eachPartido.getGolesEquipo2())
						 )
						);
					
					
				}			
				
			}
			
			
        }catch(IOException e){
        	
			System.out.println("ERROR: No se pudo leer el archivo.");
			System.exit(1);
			 	
        }catch(CantidadDeGolesEnterosException e) {
        	
        	System.out.println(e.getMessage());
        	System.exit(1);
        	
        }catch(NumeroCorrectoDeCamposException e) {
        	
        	System.out.println(e.getMessage());
        	System.exit(1);
        
        }finally {
        	
	       return estructuraDeFases;
        }
		
	}



	
	
}
	
	





