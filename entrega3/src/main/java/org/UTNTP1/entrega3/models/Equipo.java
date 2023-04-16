package org.UTNTP1.entrega3.models;


//CLASE Equipo
	public class Equipo { 
	// Definición de Atributos:
	private String nombre;
	private String descripcion;
    private int Id;
    //private static int IdSiguiente=1; // la declaramos static, entonces se transforma en una variable DE CLASE. 
    								  // No pertenece a ningún objeto, sino que es compartida por todas las instancias de la clase.
	

    // Constructor 1:
    public Equipo(int Id, String nombre, String descripcion){
    	this.nombre =nombre;
        this.descripcion = descripcion;
        this.Id = Id;    // el Id en este caso lo saco de la tabla resultados.csv, no es automático
       // Id = IdSiguiente; 
       // IdSiguiente++;  	// Luego de cada instancia incremento el Id.
        					// como ahora es IdSiguiente una variables de CLASE (porque lo definí como static), 
        					// entonces tengo que poner el nombre de la clase cuando hago el incremento Empleados.Id++ (SI ESTUVIERA FUERA DE LA CLASE Y ESTUVIERA COMO PUBLIC).
	    }
	    
    // GETTERs
    public String dameNombreEquipo(){
        return this.nombre;
    }
    public String dameDescEquipo(){
        return this.descripcion;
    }
    public int dameIdEquipo(){
        return this.Id;
    }
	    
}
	    

