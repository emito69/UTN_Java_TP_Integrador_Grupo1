package org.UTNTP1.entrega3.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.UTNTP1.entrega3.models.PronosticoObjetoParse;
import java.sql.ResultSet;

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
	
	
	// MÉTODO CONSULTA PREPARADA obtenerPronosticosParticipante()
	public List<PronosticoObjetoParse> obtenerPronosticosDeUnParticipante(String participante) throws IOException, DBConnErrorException {
		
		DBConn dbConn3 = new DBConn();
		dbConn3.conectar();
		dbConn3.obtenerPronosticosDeUnParticipante(listaDePronosticosParseados, Integer.parseInt(participante));
		
		return listaDePronosticosParseados;
		
	}
	
	
	// MÉTODO OBTENCIÓN ArrayList<String> PARTICIPANTES
	public ArrayList<String> obtenerListaDeParticipantes()  throws IOException, DBConnErrorException {
		
		DBConn dbConn2 = new DBConn();
		dbConn2.conectar();
		
		ArrayList<String> listaParticipantes = dbConn2.obtenerListaDeParticipantes();
						
		return listaParticipantes;
	
	
	}
	
	// MÉTODO CARGADOR
	public List<PronosticoObjetoParse> cargarPronosticos() throws IOException, DBConnErrorException {
		
		DBConn dbConn = new DBConn();
		dbConn.conectar();
		dbConn.obtenerPronosticos(listaDePronosticosParseados);
		
		return listaDePronosticosParseados;
		
	}

}
