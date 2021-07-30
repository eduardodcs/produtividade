package br.com.eduardo.produtividade.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.domain.Page;

import br.com.eduardo.produtividade.modelo.Funcionario;
import br.com.eduardo.produtividade.modelo.Lancamento;
import br.com.eduardo.produtividade.modelo.Meta;
import br.com.eduardo.produtividade.modelo.TipoServico;
import br.com.eduardo.produtividade.service.CalculaHorasService;
import br.com.eduardo.produtividade.service.CalculaMediaProducaoService;
import br.com.eduardo.produtividade.service.ConfereMetaBatida;

public class DetalhesLancamentoDto {

	private Long id;
	private LocalDate dataLancamento;
	private Funcionario funcionario;
	private TipoServico servico;
	private Integer quantidade;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private Double totalHoras;
	private Double media;
	private Meta metaBatida;

	public DetalhesLancamentoDto(Lancamento lancamento) {
		this.id = lancamento.getId();
		this.dataLancamento = lancamento.getDataLancamento();
		this.funcionario = lancamento.getFuncionario();
		this.servico = lancamento.getServico();
		this.quantidade = lancamento.getQuantidade();
		this.horaInicio = lancamento.getHoraInicio();
		this.horaFim = lancamento.getHoraFim();
		this.setTotalHoras(horaInicio, horaFim);
		this.setMedia(quantidade, totalHoras);
		this.setMetaBatida(media, servico);
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

	public Double getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(LocalTime horaInicio, LocalTime horaFim) {
		this.totalHoras = new CalculaHorasService().calculaQuantidadeDeHoras(horaInicio, horaFim);
	}
	
	public Double getMedia() {
		return media;
	}

	public void setMedia(Integer quantidade, Double totalHoras) {
		this.media = new CalculaMediaProducaoService().calculaMediaProducao(quantidade, totalHoras);
	}
	
	public Meta getMetaBatida() {
		return metaBatida;
	}

	public void setMetaBatida(Double media, TipoServico servico) {
		this.metaBatida = new ConfereMetaBatida().confereMeta(media, servico);
	}

	public static Page<DetalhesLancamentoDto> converter(Page<Lancamento> lancamento) {
		return lancamento.map(DetalhesLancamentoDto::new);
	}

}