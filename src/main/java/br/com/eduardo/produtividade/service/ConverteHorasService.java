package br.com.eduardo.produtividade.service;

import java.text.DecimalFormat;
import java.time.LocalTime;

public class ConverteHorasService {

	DecimalFormat formato = new DecimalFormat("#.##");
	
	public Double converterParaDecimais(LocalTime hora) {
		Double horaDecimal;
		
		if(hora.getHour() == 0) {
			horaDecimal = (double) hora.getMinute();
		} else {
			horaDecimal = (double) (hora.getHour()*60);
			horaDecimal = (double) (horaDecimal + hora.getMinute());
		}
		
		horaDecimal = Double.valueOf(formato.format(horaDecimal/60).replace(',', '.'));
		
		System.out.println(horaDecimal);
		return horaDecimal;
	}
	
}
