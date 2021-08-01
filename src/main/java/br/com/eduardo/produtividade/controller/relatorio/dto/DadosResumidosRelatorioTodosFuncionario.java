package br.com.eduardo.produtividade.controller.relatorio.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import br.com.eduardo.produtividade.modelo.Funcionario;
import br.com.eduardo.produtividade.modelo.Meta;
import br.com.eduardo.produtividade.modelo.TipoServico;
import br.com.eduardo.produtividade.repository.FuncionarioRepository;
import br.com.eduardo.produtividade.repository.TipoServicoRepository;
import br.com.eduardo.produtividade.service.CalculaMediaProducaoService;
import br.com.eduardo.produtividade.service.ConfereMetaBatida;

public class DadosResumidosRelatorioTodosFuncionario {


	private LocalDate dataLancamento;
	private Integer quantidade;
	private Double totalHoras;
	private String servico;
	private String funcionario;
	private Double media;
	private Meta metaBatida;

	public DadosResumidosRelatorioTodosFuncionario(RelatorioTodosFuncionariosDto dado
			, TipoServicoRepository tipoServicoRepository, FuncionarioRepository funcionarioRepository) {
		this.dataLancamento = LocalDate.parse(dado.getDataLancamento());
		this.quantidade = dado.getQuantidade();
		this.totalHoras = dado.getTotalHoras();
		this.setServico(dado, tipoServicoRepository);
		this.setFuncionario(dado, funcionarioRepository);
		this.setMedia(quantidade, totalHoras);
		this.setMetaBatida(media, dado, tipoServicoRepository);
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

	public void setServico(RelatorioTodosFuncionariosDto dado, TipoServicoRepository tipoServicoRepository) {
		Optional<TipoServico> servico = tipoServicoRepository.findById(Long.valueOf(dado.getServicoId()));
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

	public void setMetaBatida(Double media, RelatorioTodosFuncionariosDto dado, TipoServicoRepository tipoServicoRepository) {
		Optional<TipoServico> servico = tipoServicoRepository.findById(Long.valueOf(dado.getServicoId()));
		this.metaBatida = new ConfereMetaBatida().confereMeta(media, servico.get());
	}

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(RelatorioTodosFuncionariosDto dado, FuncionarioRepository funcionarioRepository) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(Long.valueOf(dado.getFuncionarioId()));
		this.funcionario = funcionario.get().getNome();
	}

}
