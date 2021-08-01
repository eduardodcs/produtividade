package br.com.eduardo.produtividade.controller.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardo.produtividade.controller.relatorio.dto.DadosResumidosRelatorioFuncionario;
import br.com.eduardo.produtividade.controller.relatorio.dto.DadosResumidosRelatorioTodosFuncionario;
import br.com.eduardo.produtividade.controller.relatorio.dto.RelatorioFuncionarioDto;
import br.com.eduardo.produtividade.controller.relatorio.dto.RelatorioFuncionarioRespostaDto;
import br.com.eduardo.produtividade.controller.relatorio.dto.RelatorioTodosFuncionariosDto;
import br.com.eduardo.produtividade.modelo.Funcionario;
import br.com.eduardo.produtividade.repository.FuncionarioRepository;
import br.com.eduardo.produtividade.repository.LancamentoRepository;
import br.com.eduardo.produtividade.repository.TipoServicoRepository;

@RestController
@RequestMapping("api/relatorio/funcionario")
public class RelatorioFuncionarioApi {
	
	@Autowired
	LancamentoRepository lancamentoRepository;
	@Autowired
	FuncionarioRepository funcionarioRepository;
	@Autowired
	TipoServicoRepository tipoServicoRepository;

	@GetMapping
	public List<DadosResumidosRelatorioTodosFuncionario> relatorioFuncionario(@RequestParam(value = "inicio", required = false) LocalDate inicio
			, @RequestParam(value = "fim", required = false) LocalDate fim){
		if(inicio == null || fim == null) {
			inicio = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
			fim = inicio.plusMonths(1);
		} else {
			fim = fim.plusDays(1);
		}
		List<RelatorioTodosFuncionariosDto> dadosRelatorio = lancamentoRepository.findAllByDatas(inicio, fim);
		
		List<DadosResumidosRelatorioTodosFuncionario> listaDados = new ArrayList();
		for(RelatorioTodosFuncionariosDto dado : dadosRelatorio) {
			DadosResumidosRelatorioTodosFuncionario dadoResumo = 
					new DadosResumidosRelatorioTodosFuncionario(dado, tipoServicoRepository, funcionarioRepository);
			listaDados.add(dadoResumo);
		}
		return listaDados;
	}
	
	
	@GetMapping("/{id}")
	public RelatorioFuncionarioRespostaDto relatorioFuncionario(@PathVariable Long id, @RequestParam(value = "inicio", required = false) LocalDate inicio
			, @RequestParam(value = "fim", required = false) LocalDate fim){
		if(inicio == null || fim == null) {
			inicio = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
			fim = inicio.plusMonths(1);
		} else {
			fim = fim.plusDays(1);
		}
		List<RelatorioFuncionarioDto> dadosRelatorio = lancamentoRepository.findByDatas(id, inicio, fim);
		
		List<DadosResumidosRelatorioFuncionario> listaDados = new ArrayList();
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		for(RelatorioFuncionarioDto dado : dadosRelatorio) {
			DadosResumidosRelatorioFuncionario dadoResumo = new DadosResumidosRelatorioFuncionario(dado, tipoServicoRepository);
			listaDados.add(dadoResumo);
		}
		RelatorioFuncionarioRespostaDto relatorio = new RelatorioFuncionarioRespostaDto();
		relatorio.setFuncionario(funcionario.get());
		relatorio.setDados(listaDados);
		return relatorio;
	}
	
	
}
