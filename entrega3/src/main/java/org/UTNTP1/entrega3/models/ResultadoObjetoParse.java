package org.UTNTP1.entrega3.models;

import com.opencsv.bean.CsvBindByPosition;


public class ResultadoObjetoParse {
	@CsvBindByPosition(position = 0)
	private String idFase;
	
	@CsvBindByPosition(position = 1)
	private String idRonda;
	
	@CsvBindByPosition(position = 2)
	private String idEquipo1;
	
	@CsvBindByPosition(position = 3)
	private String nombreEquipo1;
	
	@CsvBindByPosition(position = 4)
	private String descripcionEquipo1;
	
	@CsvBindByPosition(position = 5)
	private String golesEquipo1;
	
	@CsvBindByPosition(position = 6)
	private String golesEquipo2;
	
	@CsvBindByPosition(position = 7)
	private String idEquipo2;
	
	@CsvBindByPosition(position = 8)
	private String nombreEquipo2;
	
	@CsvBindByPosition(position = 9)
	private String descripcionEquipo2;

	public String getIdFase() {
		return idFase;
	}

	public void setIdFase(String idFase) {
		this.idFase = idFase;
	}

	public String getIdRonda() {
		return idRonda;
	}

	public void setIdRonda(String idRonda) {
		this.idRonda = idRonda;
	}

	public String getIdEquipo1() {
		return idEquipo1;
	}

	public void setIdEquipo1(String idEquipo1) {
		this.idEquipo1 = idEquipo1;
	}

	public String getNombreEquipo1() {
		return nombreEquipo1;
	}

	public void setNombreEquipo1(String nombreEquipo1) {
		this.nombreEquipo1 = nombreEquipo1;
	}

	public String getDescripcionEquipo1() {
		return descripcionEquipo1;
	}

	public void setDescripcionEquipo1(String descripcionEquipo1) {
		this.descripcionEquipo1 = descripcionEquipo1;
	}

	public String getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(String golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public String getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(String golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public String getIdEquipo2() {
		return idEquipo2;
	}

	public void setIdEquipo2(String idEquipo2) {
		this.idEquipo2 = idEquipo2;
	}

	public String getNombreEquipo2() {
		return nombreEquipo2;
	}

	public void setNombreEquipo2(String nombreEquipo2) {
		this.nombreEquipo2 = nombreEquipo2;
	}

	public String getDescripcionEquipo2() {
		return descripcionEquipo2;
	}

	public void setDescripcionEquipo2(String descripcionEquipo2) {
		this.descripcionEquipo2 = descripcionEquipo2;
	}
	

}
