package br.com.eduardo.produtividade.controller.form;

import javax.validation.constraints.NotEmpty;

import br.com.eduardo.produtividade.modelo.Funcionario;
import br.com.eduardo.produtividade.modelo.Status;
import br.com.eduardo.produtividade.repository.FuncionarioRepository;

public class AtualizacaoFuncionarioForm {

	@NotEmpty
	private String nome;
	private Status status;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Funcionario converter() {
		return new Funcionario(nome);
	}

	public Funcionario atualizar(Long id, FuncionarioRepository funcionarioRepository) {
		Funcionario funcionario = funcionarioRepository.getById(id);
		funcionario.setStatus(status);
		funcionario.setNome(nome);
		return funcionario;
	}

	
	
}
