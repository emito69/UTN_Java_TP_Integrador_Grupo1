package org.UTNTP1.entrega3.models;

	public class Equipo { 

	private String nombre;
	private String descripcion;
    private int Id;

    public Equipo(int Id, String nombre, String descripcion){
    	this.nombre =nombre;
        this.descripcion = descripcion;
        this.Id = Id;    // el Id en este caso lo saco de la tabla resultados.csv, no es automático
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
	    

