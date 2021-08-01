package br.com.eduardo.produtividade.controller.dto;

import java.sql.Time;

public interface RelatorioFuncionarioDto {

	String getDataLancamento();
	Integer getServicoId();
	Integer getQuantidade();
	Time getHoraInicio();
	Time getHoraFim();

}
