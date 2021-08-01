package br.com.eduardo.produtividade.controller.relatorio.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import br.com.eduardo.produtividade.modelo.Meta;
import br.com.eduardo.produtividade.modelo.TipoServico;
import br.com.eduardo.produtividade.repository.TipoServicoRepository;
import br.com.eduardo.produtividade.service.CalculaMediaProducaoService;
import br.com.eduardo.produtividade.service.ConfereMetaBatida;

public class DadosResumidosRelatorio {


	private LocalDate dataLancamento;
	private Integer quantidade;
	private Double totalHoras;
	private String servico;
	private Double media;
	private Meta metaBatida;

	public DadosResumidosRelatorio(RelatorioFuncionarioDto relatorioDto, TipoServicoRepository tipoServicoRepository) {
		this.dataLancamento = LocalDate.parse(relatorioDto.getDataLancamento());
		this.quantidade = relatorioDto.getQuantidade();
		this.totalHoras = relatorioDto.getTotalHoras();
		this.setServico(relatorioDto, tipoServicoRepository);
		this.setMedia(quantidade, totalHoras);
		this.setMetaBatida(media, relatorioDto, tipoServicoRepository);
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(Double totalHoras) {
		this.totalHoras = totalHoras;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(RelatorioFuncionarioDto relatorioDto, TipoServicoRepository tipoServicoRepository) {
		Optional<TipoServico> servico = tipoServicoRepository.findById(Long.valueOf(relatorioDto.getServicoId()));
		this.servico = servico.get().getDescricao();
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

	public void setMetaBatida(Double media, RelatorioFuncionarioDto relatorioDto, TipoServicoRepository tipoServicoRepository) {
		Optional<TipoServico> servico = tipoServicoRepository.findById(Long.valueOf(relatorioDto.getServicoId()));
		this.metaBatida = new ConfereMetaBatida().confereMeta(media, servico.get());
	}

}
