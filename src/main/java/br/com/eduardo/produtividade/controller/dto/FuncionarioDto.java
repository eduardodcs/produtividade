package br.com.eduardo.produtividade.controller.dto;

import org.springframework.data.domain.Page;

import br.com.eduardo.produtividade.modelo.Funcionario;
import br.com.eduardo.produtividade.modelo.Status;

public class FuncionarioDto {

	private Long id;
	private String nome;
	private Status status;

	public FuncionarioDto(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.status = funcionario.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public static Page<FuncionarioDto> converter(Page<Funcionario> funcionario) {
		return funcionario.map(FuncionarioDto::new);
	}

}
