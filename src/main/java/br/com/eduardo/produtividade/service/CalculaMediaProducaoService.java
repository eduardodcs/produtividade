package br.com.eduardo.produtividade.service;

import java.text.DecimalFormat;

public class CalculaMediaProducaoService {
	
	DecimalFormat formato = new DecimalFormat("#.##");

	public Double calculaMediaProducao(Integer quantidade, Double quantidadeHoras) {
		Double media = Double.valueOf(formato.format(quantidade/quantidadeHoras).replace(',', '.'));
		return media;
	}
	
}
