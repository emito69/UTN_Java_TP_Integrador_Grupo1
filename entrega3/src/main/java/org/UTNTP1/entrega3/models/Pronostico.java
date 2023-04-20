package org.UTNTP1.entrega3.models;

import java.util.ArrayList;

import org.UTNTP1.entrega3.models.ResultadoEnum.Resultado;

public class Pronostico {

	private PronosticoObjetoParse pronostico;
	
	
	public Pronostico(PronosticoObjetoParse pronostico) {
						
		this.pronostico = pronostico;
					
	}
		
	public Resultado resultado(String nombreEquipo) {
		
		if(!pronostico.getNombreEquipo1().equalsIgnoreCase(nombreEquipo) && !pronostico.getNombreEquipo2().equalsIgnoreCase(nombreEquipo)){
			System.out.println("El equipo " + nombreEquipo + " no participo de este partido");
			return null;}
		else if (pronostico.getNombreEquipo1().equalsIgnoreCase(nombreEquipo) && pronostico.getGanaEquipo1().equalsIgnoreCase("X")){
			return Resultado.ganador;}
		else if (pronostico.getNombreEquipo2().equalsIgnoreCase(nombreEquipo) && pronostico.getGanaEquipo2().equalsIgnoreCase("X")){
			return Resultado.ganador;}
		else if (pronostico.getEmpate().equalsIgnoreCase("X")) {
			return Resultado.empate;}
    	else {
    		return Resultado.perdedor;}
						
	}
	
	
	
}
