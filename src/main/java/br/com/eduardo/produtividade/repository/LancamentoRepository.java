package br.com.eduardo.produtividade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduardo.produtividade.modelo.TipoServico;

public interface LancamentoRepository extends JpaRepository<TipoServico, Long> {

	
	
}
