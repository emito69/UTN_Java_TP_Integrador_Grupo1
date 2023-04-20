package org.UTNTP1.entrega3.models;

import java.util.ArrayList;

public class Ronda {

	private String nro;

	private ArrayList<Partido> ronda;
			
    public Ronda(String nro) {
	
		this.nro = nro;
			
		this.ronda = new ArrayList<Partido>();
			
	}

    // GETTERs
    public String nro(){
    	
        return this.nro;
    }
    
    public int tamaño_ronda(){
    	
        return this.ronda.size();
    }
    
    public ArrayList<Partido> dameRonda(){
    	
        return this.ronda;
    }
    
    // Leer Partido
	public Partido partido(String nro){
		
		return ronda.get(Integer.parseInt(nro)-1);
	}	
    
    // Agregar Partido
	public void add(Partido partido){
		
		ronda.add(partido);
	}


}

