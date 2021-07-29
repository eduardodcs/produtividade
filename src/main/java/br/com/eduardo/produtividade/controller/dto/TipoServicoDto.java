package br.com.eduardo.produtividade.controller.dto;

import org.springframework.data.domain.Page;

import br.com.eduardo.produtividade.modelo.Status;
import br.com.eduardo.produtividade.modelo.TipoServico;

public class TipoServicoDto {

	private Long id;
	private String descricao;
	private Status status;

	public TipoServicoDto(TipoServico tipoServico) {
		this.id = tipoServico.getId();
		this.descricao = tipoServico.getDescricao();
		this.status = tipoServico.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public static Page<TipoServicoDto> converter(Page<TipoServico> tipoServico) {
		return tipoServico.map(TipoServicoDto::new);
	}

}
