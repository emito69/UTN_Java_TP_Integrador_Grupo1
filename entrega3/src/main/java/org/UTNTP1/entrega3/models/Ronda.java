package org.UTNTP1.entrega3.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//CLASE Ronda
public class Ronda {
	// Definición de Atributos:
	private String nro;
	private Partido[] partidos = new Partido[2];
	private String[][] matrix = new String[3][8];
	
	
    // Constructor 1:
	public Ronda(String nro, String rutaAbsolutaResultados) {
		super();
		this.nro = nro;
		armarMatrixResultados(rutaAbsolutaResultados);
		
		// Armar EQUIPOS -> PARTIDOS -> RONDA a partir de los datos almacenados en matrix
		// (suponemos un formato standarizado de resultados.csv, sino habría que identificar cada columna y fila antes de completar los contructores) 
		// también les asignamos el Id que viene de la tabla y ese se usa como referencia
		
		// AYUDA Constructores de las clases a utilizar:
		// Constructor Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2)
		// Constructor Equipo(int Id, String nombre, String descripcion)
		
			
		Equipo equipo1 = new Equipo(Integer.parseInt((matrix[1][0])), matrix[1][1], matrix[1][2]);
		Equipo equipo2 = new Equipo(Integer.parseInt((matrix[1][5])), matrix[1][6], matrix[1][7]);

		Equipo equipo3 = new Equipo(Integer.parseInt((matrix[2][0])), matrix[2][1], matrix[2][2]);
		Equipo equipo4 = new Equipo(Integer.parseInt((matrix[2][5])), matrix[2][6], matrix[2][7]);
		
		Partido partido1 = new Partido(equipo1, equipo2, Integer.parseInt((matrix[1][3])), Integer.parseInt(matrix[1][4]));
		Partido partido2 = new Partido(equipo3, equipo4, Integer.parseInt(matrix[2][3]), Integer.parseInt(matrix[2][4]));
		
		partidos[0] = partido1;
		partidos[1] = partido2;		
		
	}

    // GETTERs
    public String damenNroRonda(){
        return this.nro;
    }
    
    public Partido[] damenPartidos(){
        return this.partidos;
    }

    // FUNCIÓN AUXILIAR
private void armarMatrixResultados(String rutaAbsolutaResultados) {
    //String rutaRelativa = "src/Entrega1/archivos/resultados.csv";

    Path pathArchivo = Paths.get(rutaAbsolutaResultados); // necesito tipo Path
    
    String[] temp = new String[8]; // 8 como la cantidad de columnas de resultados.csv
    int j=0;
    try {
        for (String linea : Files.readAllLines(pathArchivo)) {
//sacar            System.out.println(linea);
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
    System.out.println(matrix[0][5]);
    System.out.println(matrix[0][6]);
    System.out.println(matrix[0][7]);
    System.out.println("PRINT matrix[1]: ");
    System.out.println(matrix[1][0]);
    System.out.println(matrix[1][1]);
    System.out.println(matrix[1][2]);
    System.out.println(matrix[1][3]);
    System.out.println(matrix[1][4]);
    System.out.println(matrix[1][5]);
    System.out.println(matrix[1][6]);
    System.out.println(matrix[1][7]);
    System.out.println("PRINT matrix[2]: ");
    System.out.println(matrix[2][0]);
    System.out.println(matrix[2][1]);
    System.out.println(matrix[2][2]);
    System.out.println(matrix[2][3]);
    System.out.println(matrix[2][4]);
    System.out.println(matrix[2][5]);
    System.out.println(matrix[2][6]);
    System.out.println(matrix[2][7]);
    */
}

}