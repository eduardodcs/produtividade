package br.com.eduardo.produtividade.controller.form;

import javax.validation.constraints.NotEmpty;

import br.com.eduardo.produtividade.modelo.TipoServico;

public class TipoServicoForm {

	@NotEmpty
	private String descricao;
	@NotEmpty
	private Long meta;
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getMeta() {
		return meta;
	}

	public void setMeta(Long meta) {
		this.meta = meta;
	}

	public TipoServico converter() {
		return new TipoServico(descricao);
	}
	
}
