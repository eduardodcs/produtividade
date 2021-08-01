package br.com.eduardo.produtividade.controller.relatorio.dto;

import java.util.List;

import br.com.eduardo.produtividade.modelo.Funcionario;

public class RelatorioFuncionarioRespostaDto {

	private Funcionario funcionario;
	private List<DadosResumidosRelatorio> dados;
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<DadosResumidosRelatorio> getDados() {
		return dados;
	}
	public void setDados(List<DadosResumidosRelatorio> dados) {
		this.dados = dados;
	}

	
	
	
	
}
