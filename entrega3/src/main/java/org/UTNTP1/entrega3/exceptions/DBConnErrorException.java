package org.UTNTP1.entrega3.exceptions;

public class DBConnErrorException extends Exception {

	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "ERROR: Hubo un problema con la conexión a la base de datos.";
	}
	
}
