package org.UTNTP1.entrega3.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.UTNTP1.entrega3.models.Partido.Resultado; 


public class Pronostico {
	
	// Definición de Atributos:
	private Ronda ronda; // resultados de la fecha
	private Partido partido;  // el partido por el que quiero consultar
	private Equipo equipo;   // el equipo por el que quiero consultar
	private String[][] matrix = new String[3][5];
	//importé la clase enum Resultado (import Entrega1.Partido.Resultado) que cree en Partido 
	// para poder hacer comparaciones con los enum que genero aquí
	Resultado pronosticoEquipo1;
	Resultado pronosticoEquipo2;
	
    // Constructor 1:
    public Pronostico(Ronda ronda, Partido partido, Equipo equipo, String rutaAbsolutaPronostico) {
    	this.ronda = ronda;
    	this.partido = partido;
    	this.equipo = equipo;
		armarMatrixPronostico(rutaAbsolutaPronostico);    
    	
		
		// Obtengo el resultado pronosticado para el partido y equipo solicitado
		int idPartido = partido.dameIdPartido(); // es 1 ó 2 para la primer parte del TP
												 // el Id del partido me define la fila en matrix
		
		
		if (matrix[idPartido][1].equalsIgnoreCase("X")){
			this.pronosticoEquipo1 = Resultado.ganador; 
			this.pronosticoEquipo2 = Resultado.perdedor;
		}
		if (matrix[idPartido][2].equalsIgnoreCase("X")){
			this.pronosticoEquipo1 = Resultado.empate; 
			this.pronosticoEquipo2 = Resultado.empate;
		}
		if (matrix[idPartido][3].equalsIgnoreCase("X")){
			this.pronosticoEquipo1 = Resultado.perdedor; 
			this.pronosticoEquipo2 = Resultado.ganador;
		}
    	
	}
	
	// GETTERS
    public int puntos() {
       	   	
    	int puntos = 0;
    	
    	if ((this.equipo.dameIdEquipo() % 2) != 0) {  // equipo 1 del partido (Id 1,3,5,etc...)
    		if (this.partido.dameResultado(equipo) == this.pronosticoEquipo1 ) {
    			puntos = 1;
    		}
    	}
    		
    	if ((this.equipo.dameIdEquipo() % 2) == 0) {  // equipo 2 del partido (Id 2,4,5,etc...)
    		if (this.partido.dameResultado(equipo) == this.pronosticoEquipo2 ) {
        		puntos = 1;
    	}    		
    	}
    	
    	//System.out.println("Id del Equipo Consultado es: " + this.equipo.dameIdEquipo());
    	//System.out.println("El Resultado REAL del Equipo y Partido consultado es: " + this.partido.dameResultado(equipo));
    	//System.out.println("PronosticoEquipo1 del partido consultado es: " + this.pronosticoEquipo1);
    	//System.out.println("PronosticoEquipo2 del partido consultado es: " + this.pronosticoEquipo2);
    	//System.out.println("Puntos de este pronóstico son: " + puntos + " puntos." );
		return puntos;
    	
    }
    
		
    // FUNCIÓN AUXILIAR
private void armarMatrixPronostico(String rutaAbsolutaPronostico) {
    //String rutaRelativa = "src/Entrega1/archivos/pronostico.csv";

    Path pathArchivo = Paths.get(rutaAbsolutaPronostico); // necesito tipo Path
    
    String[] temp = new String[5]; // 5 como la cantidad de columnas de pronostico.csv
    int j=0;
    try {
        for (String linea : Files.readAllLines(pathArchivo)) {
            //System.out.println(linea);
            temp = linea.split(";"); // se crea un array de strings de los splits que conforman esa línea
            
            for(int i=0; i<temp.length; i++){
                matrix[j][i] = temp[i]; // almaceno cada elemento del array en matrix como si fuera una tabla de datos 
                }
            j++;
            }   
        
    	}
     catch (IOException e) {
        e.printStackTrace();
     }
    /* PRUEBA DE FUNCIONAMIENTO/ALMACENAMIENTO
    System.out.println("PRINT matrix[0]: ");
    System.out.println(matrix[0][0]);
    System.out.println(matrix[0][1]);
    System.out.println(matrix[0][2]);
    System.out.println(matrix[0][3]);
    System.out.println(matrix[0][4]);
    System.out.println("PRINT matrix[1]: ");
    System.out.println(matrix[1][0]);
    System.out.println(matrix[1][1]);
    System.out.println(matrix[1][2]);
    System.out.println(matrix[1][3]);
    System.out.println(matrix[1][4]);
    System.out.println("PRINT matrix[2]: ");
    System.out.println(matrix[2][0]);
    System.out.println(matrix[2][1]);
    System.out.println(matrix[2][2]);
    System.out.println(matrix[2][3]);
    System.out.println(matrix[2][4]);
	*/
}
}