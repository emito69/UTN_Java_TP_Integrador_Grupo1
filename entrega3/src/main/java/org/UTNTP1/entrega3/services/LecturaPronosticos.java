package org.UTNTP1.entrega3.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.UTNTP1.entrega3.models.PronosticoObjetoParse;

import org.UTNTP1.entrega3.exceptions.DBConnErrorException;

public class LecturaPronosticos {
	
	private List<PronosticoObjetoParse> listaDePronosticosParseados;
		
	// CONSTRUCTOR
	public LecturaPronosticos() {
		
		this.listaDePronosticosParseados = new ArrayList<PronosticoObjetoParse>();
		
	}
	
	// GETTER
	public List<PronosticoObjetoParse> getListaDePronosticosParseados() {
		return listaDePronosticosParseados;
	}
	
	// MÉTODO OBTENCIÓN DATO CANT PARTICIPANTE
	public int obtenerCantParticipantes()  throws IOException, DBConnErrorException {
		
		DBConn dbConn2 = new DBConn();
		dbConn2.conectar();
		return	dbConn2.obtenerCantParticipantes();
		
	}
	
	// MÉTODO CARGADOR
	public List<PronosticoObjetoParse> cargarPronosticos() throws IOException, DBConnErrorException {
		
		DBConn dbConn = new DBConn();
		dbConn.conectar();
		dbConn.obtenerPronosticos(listaDePronosticosParseados);
		
		return listaDePronosticosParseados;
		
	}

}
