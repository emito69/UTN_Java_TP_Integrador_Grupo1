package org.UTNTP1.entrega3.services;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.UTNTP1.entrega3.models.ResultadoObjetoParse;

import org.UTNTP1.entrega3.exceptions.NumeroCorrectoDeCamposException;
import org.UTNTP1.entrega3.exceptions.CantidadDeGolesEnterosException;

import com.opencsv.bean.CsvToBeanBuilder;

public class LecturaResultados {

	private String rutaResultados;
	
	private List<ResultadoObjetoParse> listaDeResultadosParseados;
	
	// CONSTRUCTOR	
	public LecturaResultados (String rutaResultados) {
		
		this.rutaResultados = rutaResultados;
		
		//this.listaDeResultadosParseados = new List<ResultadoObjetoParse>();
		
	}

	// GETTER
	public List<ResultadoObjetoParse> getListaDeResultadosParseados() {
		return listaDeResultadosParseados;
	}

	
	public List<ResultadoObjetoParse> leerCSVResultados() throws NumeroCorrectoDeCamposException, CantidadDeGolesEnterosException, IOException {
		
		//this.listaDeResultadosParseados = new CsvToBeanBuilder(new FileReader(this.rutaResultados, StandardCharsets.UTF_8))
		this.listaDeResultadosParseados = new CsvToBeanBuilder<ResultadoObjetoParse>(new FileReader(this.rutaResultados, StandardCharsets.UTF_8))
						.withSkipLines(1)
						.withSeparator(';')
						.withType(ResultadoObjetoParse.class)
						.build()
						.parse();
		
		//verificarNumeroCorrectoDeCampos();
		//validarCantidadDeGolesEntero();
		
		return listaDeResultadosParseados;
			
	}
	
}
