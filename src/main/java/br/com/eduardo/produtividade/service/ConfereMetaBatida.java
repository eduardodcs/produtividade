package br.com.eduardo.produtividade.service;

import br.com.eduardo.produtividade.modelo.Meta;
import br.com.eduardo.produtividade.modelo.TipoServico;

public class ConfereMetaBatida {
	
	public Meta confereMeta(Double metaFeita, TipoServico servico) {
		if(metaFeita >= servico.getMeta()) {
			return Meta.META_BATIDA;
		}
		return Meta.META_NAO_BATIDA;
	}

}
