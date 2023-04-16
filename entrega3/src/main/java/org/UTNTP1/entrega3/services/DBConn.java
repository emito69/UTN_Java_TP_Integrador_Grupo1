package org.UTNTP1.entrega3.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		
		try {
			// Abrir la conexión
	        conexion = DriverManager.getConnection(URL_CONEX, USER, PASS);
	        
		}catch(SQLException e){
			e.printStackTrace();
			throw new DBConnErrorException();
			
	    } 
	}

	// METODO Getter PRONOTSTICO
	public void obtenerPronosticos(List<PronosticoObjetoParse> listaDePronosticosParseados) throws DBConnErrorException {
		
		Statement consulta = null;
				
		try {
			
			consulta = conexion.createStatement();
			
	        String sql = "SELECT id, idParticipante, nombreParticipante,nombreEquipo1,ganaEquipo1,empate,ganaEquipo2,nombreEquipo2 FROM entrega3.pronosticos";    
	        
	        ResultSet resultado = consulta.executeQuery(sql);
	        
	        while(resultado.next()){
	        	
	        	PronosticoObjetoParse pronosticoParseado = new PronosticoObjetoParse();
	        	pronosticoParseado.setId(resultado.getInt("id"));
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
	        	
	            if(consulta != null) consulta.close();
	        
	        }catch(SQLException e){ throw new DBConnErrorException(); }
	        
	        try{
	            
	        	if(conexion != null) conexion.close();
	       
	        }catch(SQLException e){ throw new DBConnErrorException(); }
   
		 }
	}
		
		// METODO Getter OBTENER CANT PARTICIPANTES 
		public int obtenerCantParticipantes() throws DBConnErrorException {
			
			Statement consulta2 = null;
					
			try {
				
				int size =0;
				
				consulta2 = conexion.createStatement();
				
		        String sql2 = "SELECT DISTINCT idParticipante FROM entrega3.pronosticos";    
				        
		        ResultSet rs = consulta2.executeQuery(sql2);
  		        
		        while (rs.next()) {
		            size++;
		       }
		      	              
		        //Cierra la conexión a la base de datos
		        rs.close();
		        consulta2.close();
		        conexion.close();
		        
		        return size;
		        
			 }catch(SQLException e){ 
				 
				 e.printStackTrace();
				 throw new DBConnErrorException();
			 
			 }finally{
				 
		        try{
		        	
		            if(consulta2 != null) consulta2.close();
		        
		        }catch(SQLException e){ throw new DBConnErrorException(); }
		        
		        try{
		            
		        	if(conexion != null) conexion.close();
		       
		        }catch(SQLException e){ throw new DBConnErrorException(); }
	   
			 }
			
					
		
	}
	
}
