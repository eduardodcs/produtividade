package br.com.eduardo.produtividade.controller.form;

import javax.validation.constraints.NotEmpty;

import br.com.eduardo.produtividade.modelo.Status;
import br.com.eduardo.produtividade.modelo.TipoServico;
import br.com.eduardo.produtividade.repository.TipoServicoRepository;

public class AtualizacaoTipoServicoForm {

	@NotEmpty
	private String descricao;
	private Status status;
	private Double meta;

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
	
	public TipoServico converter() {
		return new TipoServico(descricao);
	}

	public Double getMeta() {
		return meta;
	}

	public void setMeta(Double meta) {
		this.meta = meta;
	}
	
	public TipoServico atualizar(Long id, TipoServicoRepository tipoServicoRepository) {
		TipoServico tipoServico = tipoServicoRepository.getById(id);
		tipoServico.setStatus(status);
		tipoServico.setDescricao(descricao);
		tipoServico.setMeta(meta);
		return tipoServico;
	}
	
}
