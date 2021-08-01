package br.com.eduardo.produtividade.controller.form;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.eduardo.produtividade.DomainException;
import br.com.eduardo.produtividade.modelo.Funcionario;
import br.com.eduardo.produtividade.modelo.Lancamento;
import br.com.eduardo.produtividade.modelo.TipoServico;
import br.com.eduardo.produtividade.repository.FuncionarioRepository;
import br.com.eduardo.produtividade.repository.LancamentoRepository;
import br.com.eduardo.produtividade.repository.TipoServicoRepository;

public class AtualizacaoLancamentoForm {

	private static final DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotEmpty
	private String dataLancamento;
	@NotNull
	private Long funcionarioId;
	@NotNull
	private Long servicoId;
	@NotNull
	private Integer quantidade;
	@NotEmpty
	private String horaInicio;
	@NotEmpty
	private String horaFim;

	public String getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionario) {
		this.funcionarioId = funcionario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}
	
	public Long getServicoId() {
		return servicoId;
	}

	public void setServicoId(Long servico) {
		this.servicoId = servico;
	}


	public Lancamento atualizar(Long id, LancamentoRepository lancamentoRepository,
			FuncionarioRepository funcionarioRepository, TipoServicoRepository tipoServicoRepository) {
		
		Lancamento lancamento = lancamentoRepository.getById(id);
		Optional<Funcionario> funcionario = funcionarioRepository.findById(funcionarioId);
		Optional<TipoServico> servico = tipoServicoRepository.findById(servicoId);
		if(funcionario.isPresent() & servico.isPresent()) {
			lancamento.setDataLancamento(LocalDate.parse(dataLancamento, formatterDate));  
			lancamento.setFuncionario(funcionario.get());
			lancamento.setServico(servico.get());
			lancamento.setQuantidade(quantidade);
			lancamento.setHoraInicio(LocalTime.parse(horaInicio));
			lancamento.setHoraFim(LocalTime.parse(horaFim));
			lancamento.setTotalHoras(lancamento.getHoraInicio(), lancamento.getHoraFim());
			return lancamento;
		}
		throw new DomainException("Dados incorretos");
	}


}
