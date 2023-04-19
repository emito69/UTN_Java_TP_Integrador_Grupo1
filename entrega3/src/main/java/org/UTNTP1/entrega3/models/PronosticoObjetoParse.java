package org.UTNTP1.entrega3.models;

import com.opencsv.bean.CsvBindByPosition;

public class PronosticoObjetoParse {

	@CsvBindByPosition(position = 0)
	private int id;
	
	@CsvBindByPosition(position = 1)
	private int idFase;
	
	@CsvBindByPosition(position = 2)
	private int idRonda;
	
	@CsvBindByPosition(position = 3)
	private int idParticipante;
	
	@CsvBindByPosition(position = 4)
	private String nombreParticipante;
	
	@CsvBindByPosition(position = 5)
	private String nombreEquipo1;
	
	@CsvBindByPosition(position = 6)
	private String ganaEquipo1;
	
	@CsvBindByPosition(position = 7)
	private String empate;
	
	@CsvBindByPosition(position = 8)
	private String ganaEquipo2;
	
	@CsvBindByPosition(position = 9)
	private String nombreEquipo2;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFase() {
		return idFase;
	}

	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}

	public int getIdRonda() {
		return idRonda;
	}

	public void setIdRonda(int idRonda) {
		this.idRonda = idRonda;
	}

	public int getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(int idParticipante) {
		this.idParticipante = idParticipante;
	}

	public String getNombreParticipante() {
		return nombreParticipante;
	}

	public void setNombreParticipante(String nombreParticipante) {
		this.nombreParticipante = nombreParticipante;
	}

	public String getNombreEquipo1() {
		return nombreEquipo1;
	}

	public void setNombreEquipo1(String nombreEquipo1) {
		this.nombreEquipo1 = nombreEquipo1;
	}

	public String getGanaEquipo1() {
		return ganaEquipo1;
	}

	public void setGanaEquipo1(String ganaEquipo1) {
		this.ganaEquipo1 = ganaEquipo1;
	}

	public String getEmpate() {
		return empate;
	}

	public void setEmpate(String empate) {
		this.empate = empate;
	}

	public String getGanaEquipo2() {
		return ganaEquipo2;
	}

	public void setGanaEquipo2(String ganaEquipo2) {
		this.ganaEquipo2 = ganaEquipo2;
	}

	public String getNombreEquipo2() {
		return nombreEquipo2;
	}

	public void setNombreEquipo2(String nombreEquipo2) {
		this.nombreEquipo2 = nombreEquipo2;
	}

	


}
