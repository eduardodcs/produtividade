package br.com.eduardo.produtividade.controller.api;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.eduardo.produtividade.DomainException;
import br.com.eduardo.produtividade.controller.dto.DetalhesLancamentoDto;
import br.com.eduardo.produtividade.controller.dto.LancamentoDto;
import br.com.eduardo.produtividade.controller.form.AtualizacaoLancamentoForm;
import br.com.eduardo.produtividade.controller.form.LancamentoForm;
import br.com.eduardo.produtividade.modelo.Lancamento;
import br.com.eduardo.produtividade.repository.FuncionarioRepository;
import br.com.eduardo.produtividade.repository.LancamentoRepository;
import br.com.eduardo.produtividade.repository.TipoServicoRepository;


@RestController
@RequestMapping("/api/lancamento")
public class LancamentoControllerApi {
	
	@Autowired
	LancamentoRepository lancamentoRepository;
	@Autowired
	FuncionarioRepository funcionarioRepository;
	@Autowired
	TipoServicoRepository tipoServicoRepository;
	
	@GetMapping
	public Page<LancamentoDto> lista(@RequestParam(required= false) String idLancamento,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
		if(idLancamento == null) {
			Page<Lancamento> lancamento = lancamentoRepository.findAll(paginacao);
			return LancamentoDto.converter(lancamento);
		} else {
			Page<Lancamento> lancamento = lancamentoRepository.findById(idLancamento, paginacao);
			return LancamentoDto.converter(lancamento);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<LancamentoDto> cadastrar(@RequestBody @Valid LancamentoForm form, UriComponentsBuilder uriBuilder){
		Lancamento lancamento = form.converter(funcionarioRepository, tipoServicoRepository);
		if(lancamento.getHoraInicio().isBefore(lancamento.getHoraFim()) ) {
			lancamentoRepository.save(lancamento);
			URI uri = uriBuilder.path("/api/funcionario/{id}").buildAndExpand(lancamento.getId()).toUri();
			return ResponseEntity.created(uri).body(new LancamentoDto(lancamento));
		}
		throw new DomainException("A hora de inicio não pode se posterior a hora fim");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesLancamentoDto> detalhar(@PathVariable Long id){
		Optional<Lancamento> lancamento = lancamentoRepository.findById(id);
		if(lancamento.isPresent()) {
			return ResponseEntity.ok(new DetalhesLancamentoDto(lancamento.get()));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LancamentoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoLancamentoForm form){
		Optional<Lancamento> optional = lancamentoRepository.findById(id);
		if(optional.isPresent()) {
			if(optional.get().getHoraInicio().isBefore(optional.get().getHoraFim()) ) {
				Lancamento lancamento = form.atualizar(id, lancamentoRepository, funcionarioRepository, tipoServicoRepository);
				return ResponseEntity.ok(new LancamentoDto(lancamento));
			}
			throw new DomainException("A hora de inicio não pode se posterior a hora fim");
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<Lancamento> optional = lancamentoRepository.findById(id);
		if(optional.isPresent()) {
			lancamentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
