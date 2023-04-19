package org.UTNTP1.entrega3.models;

import java.util.ArrayList;

public class Fases {

	private ArrayList<Fase> fases;
	
	
	public Fases() {
			
		this.fases = new ArrayList<Fase>();
			
	}
	
    // Leer tamaño ArrayList<Fase>
	public int size(){
		
		return fases.size();
	}	
    
    // Leer Fase
	public Fase fase(String nro){
		
		return fases.get(Integer.parseInt(nro)-1);
	}	
	
    
    // Agregar Fase
	public void add(Fase fase){
		
		fases.add(fase);
	}	
	
	
}
