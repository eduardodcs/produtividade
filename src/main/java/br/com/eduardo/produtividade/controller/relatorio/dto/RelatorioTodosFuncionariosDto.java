package br.com.eduardo.produtividade.controller.relatorio.dto;

public interface RelatorioTodosFuncionariosDto {

	String getDataLancamento();
	Integer getServicoId();
	Integer getFuncionarioId();
	Integer getQuantidade();
	Double getTotalHoras();

}
