package br.com.eduardo.produtividade.service;

import java.text.DecimalFormat;
import java.time.LocalTime;

public class CalculaHorasService {

	ConverteHorasParaDecimaisService converte = new ConverteHorasParaDecimaisService();
	DecimalFormat formato = new DecimalFormat("#.##");
	
	public Double calculaQuantidadeDeHoras(LocalTime inicio, LocalTime fim) {
		Double inicioDecimal = converte.converterParaDecimais(inicio);
		Double fimDecimal = converte.converterParaDecimais(fim);
		Double totalHoras = Double.valueOf(formato.format(fimDecimal - inicioDecimal).replace(',', '.'));
		
		return totalHoras;
		
	}
	
}
