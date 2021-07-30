package br.com.eduardo.produtividade.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduardo.produtividade.modelo.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Page<Funcionario> findByNome(String nomeFuncionario, Pageable paginacao);
	
}
