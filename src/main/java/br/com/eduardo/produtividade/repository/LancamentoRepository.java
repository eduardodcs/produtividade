package br.com.eduardo.produtividade.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduardo.produtividade.modelo.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	Page<Lancamento> findById(String idLancamento, Pageable paginacao);

	
	
}
