package org.UTNTP1.entrega3.exceptions;

public class CantidadDeGolesEnterosException extends Exception{

	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "ERROR: El número de goles no es un nro entero.";
	}
}
