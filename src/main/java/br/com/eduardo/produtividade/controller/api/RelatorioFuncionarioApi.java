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

import br.com.eduardo.produtividade.controller.relatorio.dto.DadosResumidosRelatorio;
import br.com.eduardo.produtividade.controller.relatorio.dto.RelatorioFuncionarioDto;
import br.com.eduardo.produtividade.controller.relatorio.dto.RelatorioFuncionarioRespostaDto;
import br.com.eduardo.produtividade.modelo.Funcionario;
import br.com.eduardo.produtividade.repository.FuncionarioRepository;
import br.com.eduardo.produtividade.repository.LancamentoRepository;
import br.com.eduardo.produtividade.repository.TipoServicoRepository;

@RestController
@RequestMapping("api/relatorio")
public class RelatorioFuncionarioApi {
	
	@Autowired
	LancamentoRepository lancamentoRepository;
	@Autowired
	FuncionarioRepository funcionarioRepository;
	@Autowired
	TipoServicoRepository tipoServicoRepository;

	@GetMapping("/funcionario/{id}")
	public RelatorioFuncionarioRespostaDto relatorioFuncionario(@PathVariable Long id, @RequestParam(value = "inicio", required = false) LocalDate inicio
			, @RequestParam(value = "fim", required = false) LocalDate fim){
		if(inicio == null || fim == null) {
			inicio = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
			fim = inicio.plusMonths(1);
		} else {
			fim = fim.plusDays(1);
		}
		List<RelatorioFuncionarioDto> dadosRelatorio = lancamentoRepository.findByDatas(id, inicio, fim);
		
		List<DadosResumidosRelatorio> listaDados = new ArrayList();
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		for(RelatorioFuncionarioDto dado : dadosRelatorio) {
			DadosResumidosRelatorio dadoResumo = new DadosResumidosRelatorio(dado, tipoServicoRepository);
			listaDados.add(dadoResumo);
		}
		RelatorioFuncionarioRespostaDto relatorio = new RelatorioFuncionarioRespostaDto();
		relatorio.setFuncionario(funcionario.get());
		relatorio.setDados(listaDados);
		return relatorio;
	}
	
	
}
