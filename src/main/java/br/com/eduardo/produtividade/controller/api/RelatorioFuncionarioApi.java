package br.com.eduardo.produtividade.controller.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardo.produtividade.controller.dto.RelatorioFuncionarioDto;
import br.com.eduardo.produtividade.repository.LancamentoRepository;

@RestController
@RequestMapping("api/relatorio")
public class RelatorioFuncionarioApi {
	
	@Autowired
	LancamentoRepository lancamentoRepository;

	@GetMapping("/funcionario/{id}")
	public List<RelatorioFuncionarioDto> relatorioFuncionario(@PathVariable Long id, @RequestParam(value = "inicio", required = false) LocalDate inicio
			, @RequestParam(value = "fim", required = false) LocalDate fim){
		if(inicio == null || fim == null) {
			inicio = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
			fim = inicio.plusMonths(1);
		} else {
			fim = fim.plusDays(1);
		}
		List<RelatorioFuncionarioDto> dadosRelatorio = lancamentoRepository.findByDatas(id, inicio, fim);
		return dadosRelatorio;
	}
	
	
}
