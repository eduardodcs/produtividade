package br.com.eduardo.produtividade.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduardo.produtividade.modelo.TipoServico;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {

	Page<TipoServico> findByDescricao(String nomeTipoServico, Pageable paginacao);

	
	
}
