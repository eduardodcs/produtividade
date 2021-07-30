package br.com.eduardo.produtividade.controller.form;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import br.com.eduardo.produtividade.repository.TipoServicoRepository;

public class LancamentoForm {
	
	private static final DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotEmpty
	private String dataLancamento;
	@NotNull
	private Long funcionarioId;
	@NotNull
	private Long servicoId;
	@NotNull
	private int quantidade;
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

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
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

	public void setServicoId(Long servicoId) {
		this.servicoId = servicoId;
	}


	public Lancamento converter(FuncionarioRepository funcionarioRepository, TipoServicoRepository tipoServicoRepository) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(funcionarioId);
		Optional<TipoServico> servico = tipoServicoRepository.findById(servicoId);
		if(funcionario.isPresent() & servico.isPresent()) {
			Lancamento lancamento = new Lancamento();
			lancamento.setDataLancamento(LocalDate.parse(this.dataLancamento, formatterDate));
			lancamento.setFuncionario(funcionario.get());
			lancamento.setServico(servico.get());
			lancamento.setQuantidade(quantidade);
			lancamento.setHoraInicio(LocalTime.parse(horaInicio));
			lancamento.setHoraFim(LocalTime.parse(horaFim));	
			return lancamento;
		}
		throw new DomainException("Dados incorretos");
	}

}
