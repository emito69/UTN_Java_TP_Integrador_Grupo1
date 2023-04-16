package org.UTNTP1.entrega3.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static String JDBC_DRIVER;
	private static String URL_CONEX;
	private static String USER;
	private static String PASS;
	private static int puntosPorAcierto;
	private static int puntosExtraRonda;
	private static int puntosExtraFaseEquipo;
	
	public ConfigReader(String archivoConfigProp) throws IOException {
		
		Properties propiedades = new Properties();
		
		propiedades.load(new FileReader(archivoConfigProp));
		
		JDBC_DRIVER = propiedades.getProperty("JDBC_DRIVER");
		
		URL_CONEX = propiedades.getProperty("URL_CONEX");
		USER = propiedades.getProperty("USER");
		PASS = propiedades.getProperty("PASS");
		
		puntosPorAcierto = Integer.parseInt(propiedades.getProperty("PUNTOS_POR_ACIERTO"));
		puntosExtraRonda = Integer.parseInt(propiedades.getProperty("PUNTOS_EXTRA_RONDA"));
		puntosExtraFaseEquipo = Integer.parseInt(propiedades.getProperty("PUNTOS_EXTRA_FASE_EQUIPO"));
		
	}

	public static String getJDBC_DRIVER() {
		return JDBC_DRIVER;
	}

	public static int getPuntosPorAcierto() {
		return puntosPorAcierto;
	}

	public static int getPuntosExtraRonda() {
		return puntosExtraRonda;
	}

	public static int getPuntosExtraFaseEquipo() {
		return puntosExtraFaseEquipo;
	}

	public static String getURL_CONEX() {
		return URL_CONEX;
	}

	public static String getUSER() {
		return USER;
	}

	public static String getPASS() {
		return PASS;
	}
	
}
