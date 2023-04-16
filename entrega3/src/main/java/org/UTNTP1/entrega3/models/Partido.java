package org.UTNTP1.entrega3.models;

//CLASE Partido
	public class Partido {
		// Definición de Atributos:
		private Equipo equipo1;
		private Equipo equipo2;
		private int golesEquipo1;
		private int golesEquipo2;
	    private int Id;
	    private static int IdSiguiente=1; // la declaramos static, entonces se transforma en una variable DE CLASE. 
	    								  // No pertenece a ningún objeto, sino que es compartida por todas las instancias de la clase.
		
	    public enum Resultado {ganador, perdedor, empate} //  clase Resultado (que tenga primer letra mayúscula por convención de nombre de clases).
		
	    //private Resultado resultadoEquipo;
		
	    // Constructor 1:
	    public Partido(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2)     {
	    	this.equipo1 = equipo1;
	    	this.equipo2 = equipo2;
	    	this.golesEquipo1 = golesEquipo1;
	    	this.golesEquipo2 = golesEquipo2;
	        Id = IdSiguiente; 
	        IdSiguiente++;  	// Luego de cada instancia incremento el Id.
	        					// como ahora es IdSiguiente una variables de CLASE (porque lo definí como static), 
	        					// entonces tengo que poner el nombre de la clase cuando hago el incremento Empleados.Id++ (SI ESTUVIERA FUERA DE LA CLASE Y ESTUVIERA COMO PUBLIC).
		    }
		    
	    // GETTERs
	    // El tipo de return del método tiene que ser tipo "Resultado" que es la clase enum que cree
	    public Resultado dameResultado(Equipo equipox){	    	
	    	if (equipox.dameIdEquipo() == equipo1.dameIdEquipo()) {
	    		if(golesEquipo1 > golesEquipo2) {
	    			//this.resultadoEquipo = Resultado.ganador;
	    			return Resultado.ganador;}
	    		else if (golesEquipo1 < golesEquipo2) {
	    			//this.resultadoEquipo = Resultado.perdedor;
	    			return Resultado.perdedor;}
				else {
	    			//this.resultadoEquipo = Resultado.empate;					
					return Resultado.empate;}
	    	}
	    	
	    	else if (equipox.dameIdEquipo() == equipo2.dameIdEquipo()){
	    		if(golesEquipo2 > golesEquipo1) {
	    			//this.resultadoEquipo = Resultado.ganador;
	    			return Resultado.ganador;}
	    		else if (golesEquipo2 < golesEquipo1) {
	    			//this.resultadoEquipo = Resultado.perdedor;
	    			return Resultado.perdedor;}
				else {
	    			//this.resultadoEquipo = Resultado.empate;		
					return Resultado.empate;}
	    	}
	    	else {
	    		System.out.println("El equipo " + equipox.dameNombreEquipo() + " no participo de este partido");
	    		return null;
	    	}
	    }
	    	
	    public int dameIdPartido(){
	        return this.Id;
	    }
	    
	    public Equipo dameEquipo1(){
	        return this.equipo1;
	    }
	    
	    public Equipo dameEquipo2(){
	        return this.equipo2;
	    } 
	    
	}
	

	
		    

		  
