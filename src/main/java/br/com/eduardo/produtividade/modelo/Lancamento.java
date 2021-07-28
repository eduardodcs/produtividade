package br.com.eduardo.produtividade.modelo;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.eduardo.produtividade.service.CalculaHorasService;
import br.com.eduardo.produtividade.service.CalculaMediaProducaoService;

@Entity
public class Lancamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataLancamento;
	@ManyToOne
	private Funcionario funcionario;
	private Integer quantidade;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private LocalDateTime dataCriacao = LocalDateTime.now();

	public Lancamento(LocalDate dataLancamento, Funcionario funcionario, Integer quantidade, LocalTime horaInicio,
			LocalTime horaFim) {
		
		this.dataLancamento = dataLancamento;
		this.funcionario = funcionario;
		this.quantidade = quantidade;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
