package org.UTNTP1.entrega3.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import org.UTNTP1.entrega3.config.ConfigReader;

import org.UTNTP1.entrega3.models.ResultadoEnum.Resultado;


public class PuntosPronostico {
	
	// Definición de Atributos:
	private Fases fases; // resultados disponibles a la fecha
	private List<PronosticoObjetoParse> pronosticosParticipante; // pronosticos de todos los partidos, de todas las rondas, de todas las fases de un participante 
	private HashSet<String> listaEquipos;
	
	private ArrayList<ArrayList<Integer>> listaAciertosRondas;
	private ArrayList<Integer> aciertosRondas;
	
	private ArrayList<ArrayList<Integer>> prueba1;
	private ArrayList<Integer> prueba12;
	
	private ArrayList<Hashtable<String, Integer>> listaAciertosEquiposenFases;
	private Hashtable<String, Integer> aciertosEquiposEnFases;
	
	private int tamanioFases;
	private int tamanioFase;
	private int tamanioRonda;
	private int cantidadEquipos;
	
	private int puntosTotales;
	
	//private Ronda ronda; // resultados de la fecha
	//private Partido partido;  // el partido por el que quiero consultar
	//private Equipo equipo;   // el equipo por el que quiero consultar
	//private String[][] matrix = new String[3][5];
	
	//importé la clase enum Resultado (import Entrega1.Partido.Resultado) que cree en Partido 
	// para poder hacer comparaciones con los enum que genero aquí
	//Resultado pronosticoEquipo1;
	//Resultado pronosticoEquipo2;
	
	
	//--- DATOS DE CONFIGURACIÓN DE PUNTOS -----------------
	
	//PUNTOS_POR_ACIERTO
    public static final int PUNTOS_POR_ACIERTO = ConfigReader.getPuntosPorAcierto();
    
    //PUNTOS_EXTRA_RONDA
    public static final int PUNTOS_EXTRA_RONDA = ConfigReader.getPuntosExtraRonda();

    //PUNTOS_EXTRA_FASE_EQUIPO
    public static final int PUNTOS_EXTRA_FASE_EQUIPO = ConfigReader.getPuntosExtraFaseEquipo();

    
    //------------------------------------------------------------
	
	
    // Constructor 1:
    public PuntosPronostico(Fases fases, List<PronosticoObjetoParse> pronosticosParticipante, HashSet<String> listaEquipos) {
    	
    	this.fases = fases;
    	this.pronosticosParticipante = pronosticosParticipante;
    	this.listaEquipos = listaEquipos;
    	   	
    	
    	//INICIALIZAMOS listaAciertosRondas
    	this.tamanioFases = fases.size();
    	//System.out.println("tamanioFases: " + tamanioFases);
    	this.tamanioFase = fases.fase("1").size();
    	//System.out.println("tamanioFase: " + tamanioFase);
    	this.tamanioRonda = fases.fase("1").ronda("1").tamaño_ronda();
    	//System.out.println("tamanioRonda: " + tamanioRonda);

    	
    	//INICIALIZAMOS listaAciertosEquiposenFases
    	this.cantidadEquipos = listaEquipos.size();
    	
    	this.aciertosEquiposEnFases = new Hashtable<String, Integer>();
    	
    	for (String e : listaEquipos) {
        	
    		aciertosEquiposEnFases.put(e, 0); // agrego pares <nombreEquipo, puntos>
    	
    	}
    	    	
    	this.listaAciertosEquiposenFases = new ArrayList<Hashtable<String, Integer>>();
    	for (int i=0; i<tamanioFase; i++) {
    	
    		listaAciertosEquiposenFases.add(aciertosEquiposEnFases);
    		
    	}
    		
    	
    	puntosTotales = 0;
    	    	
    	int puntos = 0;
    	int i=1; // reinicio el nro de partido
    	
    	int valorAnterior0 =0;
    	int valorAnterior1 =0;
    	int valorAnterior2 =0;
    	
    	int[][] matrix = new int[tamanioFases][tamanioFase];
    	int max;
    	
    	for (int x=0; x < matrix.length; x++) {
            for (int y=0 ; y < matrix[x].length; y++) {
                matrix[x][y] = 0;
            }
        }
        
    	
    	// Recorro todos los pronósticos del Participante
    	for (PronosticoObjetoParse p: pronosticosParticipante) {
    		
    		String nroFase = String.valueOf(p.getIdFase());
    		String nroRonda = String.valueOf(p.getIdRonda());
    		String nroPartido = String.valueOf(i - (4 * (p.getIdRonda()-1)) - (8 * (p.getIdFase()-1)) );

    		
    		Pronostico prono = new Pronostico(p);
    			
    		//int cant_partidos = fases.fase(nroFase).ronda(nroRonda).tamaño_ronda();
    		//System.out.println(nroFase);	
    		//System.out.println(nroRonda);
    		//System.out.println(nroPartido);
    		//System.out.println(nroPartido);
    		
    		// Recorro todos los partidos de cada ronda y obtengo los puntos del Participante 
    		    		
    		Partido equipoEMI =  fases.fase(nroFase).ronda(nroRonda).partido(nroPartido);
    		
    		Equipo equipo1 =  fases.fase(nroFase).ronda(nroRonda).partido(nroPartido).dameEquipo1();  //objeto equipo1
    		Equipo equipo2 =  fases.fase(nroFase).ronda(nroRonda).partido(nroPartido).dameEquipo2();  //objeto equipo2
    		    		
    		
    		if (fases.fase(nroFase).ronda(nroRonda).partido(nroPartido).resultado(equipo1) == prono.resultado(p.getNombreEquipo1())
    			&&
    			fases.fase(nroFase).ronda(nroRonda).partido(nroPartido).resultado(equipo2) == prono.resultado(p.getNombreEquipo2())    				
    				) { // hago así para evitar que el participante cargue X en varios posibles resultados
    			
    			// **** SUMO LOS PUNTOS DE ESTE PARTIDO:
    			puntos = puntos + PUNTOS_POR_ACIERTO;
    			
    			
    			// **** SUMO ACIERTOS A CADA RONDA:
    			// cada ronda es de 4 partidos, así que si acertó todos esa ronda sumaría 4 aciertos
    			
    			valorAnterior0 = matrix[p.getIdFase()-1][p.getIdRonda()-1];
    			matrix[p.getIdFase()-1][p.getIdRonda()-1]= valorAnterior0+1;
    			
    			// **** SUMO ACIERTOS A CADA FASE:
    			// cada equipo juega en una 2 VECES en una Ronda -- y esa cantidad por la cantidad de rondas en la fase 
    			// este valor podríamos ponerlo en el CONFIG porque depende de cómo se organiza el torneo
    			// no hay una regla clara
    			// si 
    			
    			valorAnterior1 = listaAciertosEquiposenFases.get(p.getIdFase()-1).get(p.getNombreEquipo1());
    			listaAciertosEquiposenFases.get(p.getIdFase()-1).put(p.getNombreEquipo1(), valorAnterior1+1);
    			valorAnterior2 = listaAciertosEquiposenFases.get(p.getIdFase()-1).get(p.getNombreEquipo1());
    			listaAciertosEquiposenFases.get(p.getIdFase()-1).put(p.getNombreEquipo2(), valorAnterior2+1);
    			
    		}
    			    			
    		i++;	      		
    		
    	}
    	
    	/*
    	// IMPRIMIMOS LOS PUNTOS POR PARTIDOS 
    	System.out.println("EMI puntos participante por PARTIDOS: " + puntos);    
    	*/
    	/*
    	// IMPRIMIMOS LOS ACIERTOS POR RONDA
    	for (int x=0; x < matrix.length; x++) {
            for (int y=0 ; y < matrix[x].length; y++) {
            	System.out.println("aciertos Ronda: "+matrix[x][y]);
            }
                //System.out.println(arr[x][y]);
        }
    	*/
    	// IMPRIMIMOS LOS ACIERTOS POR EQUIPOS POR FASE
	    
    	for (Hashtable<String, Integer> h: listaAciertosEquiposenFases) {
	    	
	           System.out.println("Key /Value: " + h);
	    }
    	
    	// IMPRIMIMOS RESULTADOS GLOBALES
	        	
    	System.out.println("PARTICIPANTE :" + pronosticosParticipante.get(1).getNombreParticipante());
    	
    	int tempRONDAS=0;
    	
    	for (int x=0; x < matrix.length; x++) {
            for (int y=0 ; y < matrix[x].length; y++) {
            	if (matrix[x][y] == tamanioRonda) {
            		tempRONDAS+= PUNTOS_EXTRA_RONDA; 
            	}
            }
                //System.out.println(arr[x][y]);
        }
    		
    	
    	int tempFASES=0;
    	
    	for (Hashtable<String, Integer> fas : listaAciertosEquiposenFases) {
    		
    		for (String key : listaEquipos) {
    			
    			if(fas.get(key) == (2*tamanioFase)) {
    				tempFASES += PUNTOS_EXTRA_FASE_EQUIPO;
    			}
    			
    		}
    		
    	}
    	
    	int total = puntos + tempRONDAS + tempFASES;

    	System.out.println("Total de puntos: " + total);
    
    
    
    }



}