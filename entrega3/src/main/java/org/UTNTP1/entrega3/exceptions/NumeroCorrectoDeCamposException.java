package org.UTNTP1.entrega3.exceptions;

public class NumeroCorrectoDeCamposException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "ERROR: El número de campos del archivo resultados.csv es incorrecto.";
	}
	
}
