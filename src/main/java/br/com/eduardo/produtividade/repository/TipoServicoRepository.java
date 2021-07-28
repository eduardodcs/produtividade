package br.com.eduardo.produtividade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduardo.produtividade.modelo.Funcionario;

public interface TipoServicoRepository extends JpaRepository<Funcionario, Long> {

	
	
}
