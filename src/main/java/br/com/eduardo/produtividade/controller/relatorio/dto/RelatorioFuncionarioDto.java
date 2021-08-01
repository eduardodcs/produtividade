package br.com.eduardo.produtividade.controller.relatorio.dto;

public interface RelatorioFuncionarioDto {

	String getDataLancamento();
	Integer getServicoId();
	Integer getQuantidade();
	Double getTotalHoras();

}
