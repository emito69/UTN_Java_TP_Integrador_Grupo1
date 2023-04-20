package org.UTNTP1.entrega3.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.UTNTP1.entrega3.exceptions.DBConnErrorException;
import org.UTNTP1.entrega3.models.PronosticoObjetoParse;

import org.UTNTP1.entrega3.config.ConfigReader;

public class DBConn {
	
	
	//--- DATOS CONECTOR MYSQL DEL CONFIG-----------------
	
	//Driver conector JDBC-MySQL
    public static final String JDBC_DRIVER = ConfigReader.getJDBC_DRIVER();
    
    //URL de la Base de Datos
    public static final String URL_CONEX = ConfigReader.getURL_CONEX();

    //Credenciales
    public static final String USER = ConfigReader.getUSER();
    public static final String PASS = ConfigReader.getPASS();
    
    //------------------------------------------------------------
	
	private Connection conexion = null;
	
	
	// METODO Conectar
	public void conectar() throws DBConnErrorException{
		
		System.out.println("");
        //System.out.println("conectando a la base de datos...");
        //System.out.println("");
		try {
			// Abrir la conexión
	        conexion = DriverManager.getConnection(URL_CONEX, USER, PASS);
	        
		}catch(SQLException e){
			e.printStackTrace();
			throw new DBConnErrorException();
			
	    } 
	}

	// METODO Obtener LISTA con EQUIPOS
			public ArrayList<String> obtenerListaDeEquipos() throws DBConnErrorException {
				
				Statement consulta4 = null;
						
				try {
							
					consulta4 = conexion.createStatement();
					
			        String sql4 = "SELECT DISTINCT nombreEquipo1 FROM entrega3.pronosticos";    
					        
			        ResultSet resultadoE1 = consulta4.executeQuery(sql4);
	  		        		        	      	              
	     	        	        
			        ArrayList<String> listaEquipos = new ArrayList<String>();
			        
			        while(resultadoE1.next()){
			        	
			        	listaEquipos.add(resultadoE1.getString("nombreEquipo1"));
			        			        		        
			        }
			        
			        sql4 = "SELECT DISTINCT nombreEquipo2 FROM entrega3.pronosticos";    
			        
			        ResultSet resultadoE2 = consulta4.executeQuery(sql4);
	  		        		        	      	              
			        
			        while(resultadoE2.next()){
			        	
			        	listaEquipos.add(resultadoE2.getString("nombreEquipo2"));
			        			        		        
			        }
			        
			        //Cierra la conexión a la base de datos
			        resultadoE1.close();
			        resultadoE2.close();
			        consulta4.close();
			        conexion.close();
			        
					return listaEquipos;
					
			        
				 }catch(SQLException e){ 
					 
					 e.printStackTrace();
					 throw new DBConnErrorException();
				 
				 }finally{
					 
					 try{
				        	
				         if(consulta4 != null) {
				         	consulta4.close();
				         }
				        
				     }catch(SQLException e){ 
				        
				        	throw new DBConnErrorException(); 
				        }
				        
				     try{
				            
				      		if(conexion != null) {
				        		conexion.close();
				        	}
				       
				      }catch(SQLException e){ 
				        
				        	throw new DBConnErrorException(); 
				        }
		   
				 }
			}
		
		// METODO Obtener LISTA con PARTICIPANTES 
		public ArrayList<String> obtenerListaDeParticipantes() throws DBConnErrorException {
			
			Statement consulta2 = null;
					
			try {
						
				consulta2 = conexion.createStatement();
				
		        String sql2 = "SELECT DISTINCT idParticipante FROM entrega3.pronosticos";    
				        
		        ResultSet resultadoL = consulta2.executeQuery(sql2);
  		        		        	      	              
     	        	        
		        ArrayList<String> listaParticipantes = new ArrayList<String>();
		        
		        while(resultadoL.next()){
		        	
		        	listaParticipantes.add(resultadoL.getString("idParticipante"));
		        			        		        
		        }
		        
		        //Cierra la conexión a la base de datos
		        resultadoL.close();
		        consulta2.close();
		        conexion.close();
		        
				return listaParticipantes;
				
		        
			 }catch(SQLException e){ 
				 
				 e.printStackTrace();
				 throw new DBConnErrorException();
			 
			 }finally{
				 
				 try{
			        	
			         if(consulta2 != null) {
			         	consulta2.close();
			         }
			        
			     }catch(SQLException e){ 
			        
			        	throw new DBConnErrorException(); 
			        }
			        
			     try{
			            
			      		if(conexion != null) {
			        		conexion.close();
			        	}
			       
			      }catch(SQLException e){ 
			        
			        	throw new DBConnErrorException(); 
			        }
	   
			 }
		}
			
			
		
		// CONSULTA PREPARADA por PARTICIPANTE 
		public void obtenerPronosticosDeUnParticipante(List<PronosticoObjetoParse> listaDePronosticosParseadosP, int participante) throws DBConnErrorException {
					
					PreparedStatement consulta3 = null;  // Preparedstatement 
					
					try {
						
						listaDePronosticosParseadosP.clear();
						
						// PREPARAMOS LA CONSULTA
				        consulta3 = conexion.prepareStatement("SELECT * FROM entrega3.pronosticos WHERE idParticipante = ?");
				        
				        // ESTABLECEMOS EL PAÁMETRO DE LA CONSULTA
				        consulta3.setInt(1, participante);  // es setInt porque es el tipo de dato idParticipante en la TABLA
				        				       	        
				        // EJECUTAR CONSULTA
				        ResultSet resultadoP = consulta3.executeQuery();
				        
				        while(resultadoP.next()){
				        	
				        	PronosticoObjetoParse pronosticosDeUnParticipanteParseados = new PronosticoObjetoParse();
				        	
				        	pronosticosDeUnParticipanteParseados.setId(resultadoP.getInt("id"));
				        	pronosticosDeUnParticipanteParseados.setIdFase(resultadoP.getInt("idFase"));
				        	pronosticosDeUnParticipanteParseados.setIdRonda(resultadoP.getInt("idRonda"));
				        	pronosticosDeUnParticipanteParseados.setIdParticipante(resultadoP.getInt("idParticipante"));
				        	pronosticosDeUnParticipanteParseados.setNombreParticipante(resultadoP.getString("nombreParticipante"));
				        	pronosticosDeUnParticipanteParseados.setNombreEquipo1(resultadoP.getString("nombreEquipo1"));
				        	pronosticosDeUnParticipanteParseados.setGanaEquipo1(resultadoP.getString("ganaEquipo1"));
				        	pronosticosDeUnParticipanteParseados.setEmpate(resultadoP.getString("empate"));
				        	pronosticosDeUnParticipanteParseados.setGanaEquipo2(resultadoP.getString("ganaEquipo2"));
				        	pronosticosDeUnParticipanteParseados.setNombreEquipo2( resultadoP.getString("nombreEquipo2"));
				        	    	
				        	listaDePronosticosParseadosP.add(pronosticosDeUnParticipanteParseados);
				        		        
				        }
				        
				        //Cierra la conexión a la base de datos
				        resultadoP.close();
				        consulta3.close();
				        conexion.close();
			        
					 }catch(SQLException e){ 
						 
						 e.printStackTrace();
						 throw new DBConnErrorException();
					 
					 }finally{
						 
				        try{
				        	
				            if(consulta3 != null) {
				            	consulta3.close();
				            }
				        
				        }catch(SQLException e){ 
				        
				        	throw new DBConnErrorException(); 
				        }
				        
				        try{
				            
				        	if(conexion != null) {
				        		conexion.close();
				        	}
				       
				        }catch(SQLException e){ 
				        
				        	throw new DBConnErrorException(); 
				        }
			   
					 }
				}		

		
		

		
		
		
			// METODO Getter PRONOSTICOS
			public void obtenerPronosticos(List<PronosticoObjetoParse> listaDePronosticosParseados) throws DBConnErrorException {
				
				Statement consulta = null;
						
				try {
					
					listaDePronosticosParseados.clear();
					
					consulta = conexion.createStatement();
					
			        String sql = "SELECT id, idFase, idRonda, idParticipante, nombreParticipante,nombreEquipo1,ganaEquipo1,empate,ganaEquipo2,nombreEquipo2 FROM entrega3.pronosticos";    
			        
			        ResultSet resultado = consulta.executeQuery(sql);
			        
			        while(resultado.next()){
			        	
			        	PronosticoObjetoParse pronosticoParseado = new PronosticoObjetoParse();
			        	pronosticoParseado.setId(resultado.getInt("id"));
			        	pronosticoParseado.setIdFase(resultado.getInt("idFase"));
			        	pronosticoParseado.setIdRonda(resultado.getInt("idRonda"));
			        	pronosticoParseado.setIdParticipante(resultado.getInt("idParticipante"));
			        	pronosticoParseado.setNombreParticipante(resultado.getString("nombreParticipante"));
			        	pronosticoParseado.setNombreEquipo1(resultado.getString("nombreEquipo1"));
			        	pronosticoParseado.setGanaEquipo1(resultado.getString("ganaEquipo1"));
			        	pronosticoParseado.setEmpate(resultado.getString("empate"));
			        	pronosticoParseado.setGanaEquipo2(resultado.getString("ganaEquipo2"));
			        	pronosticoParseado.setNombreEquipo2( resultado.getString("nombreEquipo2"));
			        	    	
			        	listaDePronosticosParseados.add(pronosticoParseado);
			        		        
			        }
			        
			        //Cierra la conexión a la base de datos
			        resultado.close();
			        consulta.close();
			        conexion.close();
		        
				 }catch(SQLException e){ 
					 
					 e.printStackTrace();
					 throw new DBConnErrorException();
				 
				 }finally{
					 
			        try{
			        	
			            if(consulta != null) {
			            	consulta.close();
			            }
			        
			        }catch(SQLException e){ 
			        
			        	throw new DBConnErrorException(); 
			        }
			        
			        try{
			            
			        	if(conexion != null) {
			        		conexion.close();
			        	}
			       
			        }catch(SQLException e){ 
			        
			        	throw new DBConnErrorException(); 
			        }
		   
				 }
			}		
		
		
		
	
}
