package br.com.eduardo.produtividade.controller.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.domain.Page;

import br.com.eduardo.produtividade.controller.relatorio.dto.RelatorioFuncionarioDto;
import br.com.eduardo.produtividade.modelo.Lancamento;
import br.com.eduardo.produtividade.modelo.Meta;
import br.com.eduardo.produtividade.modelo.TipoServico;
import br.com.eduardo.produtividade.service.CalculaHorasService;
import br.com.eduardo.produtividade.service.CalculaMediaProducaoService;
import br.com.eduardo.produtividade.service.ConfereMetaBatida;

public class DetalhesLancamentoDto {
	
	private Long id;
	private LocalDate dataLancamento;
	private String funcionario;
	private String servico;
	private Integer quantidade;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private Double totalHoras;
	private Double media;
	private Meta metaBatida;

	public DetalhesLancamentoDto(Lancamento lancamento) {
		this.id = lancamento.getId();
		this.dataLancamento = lancamento.getDataLancamento();
		this.funcionario = lancamento.getFuncionario().getNome();
		this.servico = lancamento.getServico().getDescricao();
		this.quantidade = lancamento.getQuantidade();
		this.horaInicio = lancamento.getHoraInicio();
		this.horaFim = lancamento.getHoraFim();
		this.totalHoras = lancamento.getTotalHoras();
		this.setMedia(quantidade, totalHoras);
		this.setMetaBatida(media, lancamento.getServico());
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

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
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

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public static Page<DetalhesLancamentoDto> converter(Page<Lancamento> lancamento) {
		return lancamento.map(DetalhesLancamentoDto::new);
	}

}
