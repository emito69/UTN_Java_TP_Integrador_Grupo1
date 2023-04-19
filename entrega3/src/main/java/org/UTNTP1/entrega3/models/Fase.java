package org.UTNTP1.entrega3.models;

import java.util.ArrayList;

public class Fase {

	private String nro;

	private ArrayList<Ronda> fase;
			
    
	public Fase(String nro) {
	
		this.nro = nro;
			
		this.fase = new ArrayList<Ronda>();
			
	}

    // GETTERs
    public String nro(){
    	
        return this.nro;
    }
    
    // Leer tamaño ArrayList<Ronda>
	public int size(){
		
		return fase.size();
	}	
    
    // Leer Ronda
	public Ronda ronda(String nro){
		//System.out.println("NRO DE RONDA A CARGAR :" +(Integer.parseInt(nro)-1));
		return fase.get(Integer.parseInt(nro)-1);
	}	
    
    // Agregar Ronda
	public void add(Ronda ronda){
		
		fase.add(ronda);
	}


}
