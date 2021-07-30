package br.com.eduardo.produtividade.controller.form;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.eduardo.produtividade.modelo.Funcionario;
import br.com.eduardo.produtividade.modelo.Lancamento;
import br.com.eduardo.produtividade.modelo.Status;
import br.com.eduardo.produtividade.modelo.TipoServico;
import br.com.eduardo.produtividade.repository.LancamentoRepository;
import br.com.eduardo.produtividade.repository.TipoServicoRepository;

public class AtualizacaoLancamentoForm {

	@NotEmpty
	private LocalDate dataLancamento;
	@NotEmpty
	private Funcionario funcionario;
	@NotNull
	private TipoServico servico;
	@NotEmpty
	private Integer quantidade;
	@NotEmpty
	private LocalTime horaInicio;
	@NotEmpty
	private LocalTime horaFim;

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	public Lancamento atualizar(Long id, LancamentoRepository lancamentoRepository) {
		Lancamento lancamento = lancamentoRepository.getById(id);
		lancamento.setDataLancamento(dataLancamento);  
		lancamento.setFuncionario(funcionario);
		lancamento.setQuantidade(quantidade);
		lancamento.setHoraInicio(horaInicio);
		lancamento.setHoraFim(horaFim);
		return lancamento;
	}

}
