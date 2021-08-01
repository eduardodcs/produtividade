package br.com.eduardo.produtividade.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.eduardo.produtividade.controller.api.RelatorioFuncionarioApi;
import br.com.eduardo.produtividade.controller.dto.RelatorioFuncionarioDto;
import br.com.eduardo.produtividade.modelo.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	Page<Lancamento> findById(String idLancamento, Pageable paginacao);

	@Query(value = "SELECT L.DATA_LANCAMENTO AS dataLancamento, "
			+ "L.SERVICO_ID AS servicoId, "
			+ "L.QUANTIDADE AS quantidade, "
			+ "L.HORA_INICIO AS horaInicio, "
			+ "L.HORA_FIM AS horaFim "
			+ "FROM LANCAMENTO L "
			+ "WHERE L.FUNCIONARIO_ID = :id "
			+ "AND L.DATA_LANCAMENTO >= :inicio "
			+ "AND L.DATA_LANCAMENTO < :fim "

			, nativeQuery = true)
	List<RelatorioFuncionarioDto> findByDatas(Long id, LocalDate inicio, LocalDate fim);
	
}
