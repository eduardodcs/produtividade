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

import br.com.eduardo.produtividade.controller.dto.DetalhesTipoServicoDto;
import br.com.eduardo.produtividade.controller.dto.TipoServicoDto;
import br.com.eduardo.produtividade.controller.form.AtualizacaoTipoServicoForm;
import br.com.eduardo.produtividade.controller.form.TipoServicoForm;
import br.com.eduardo.produtividade.modelo.TipoServico;
import br.com.eduardo.produtividade.repository.TipoServicoRepository;

@RestController
@RequestMapping("/api/tipo-servico")
public class TipoServicoControllerApi {
	
	@Autowired
	TipoServicoRepository tipoServicoRepository;
	
	@GetMapping
	public Page<TipoServicoDto> lista(@RequestParam(required= false) String nomeTipoServico,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
		if(nomeTipoServico == null) {
			Page<TipoServico> tipoServico = tipoServicoRepository.findAll(paginacao);
			return TipoServicoDto.converter(tipoServico);
		} else {
			Page<TipoServico> tipoServico = tipoServicoRepository.findByDescricao(nomeTipoServico, paginacao);
			return TipoServicoDto.converter(tipoServico);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<TipoServicoDto> cadastrar(@RequestBody @Valid TipoServicoForm form, UriComponentsBuilder uriBuilder){
		TipoServico tipoServico = form.converter();
		tipoServicoRepository.save(tipoServico);
		
		URI uri = uriBuilder.path("/api/tipo-servico/{id}").buildAndExpand(tipoServico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TipoServicoDto(tipoServico));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesTipoServicoDto> detalhar(@PathVariable Long id){
		Optional<TipoServico> tipoServico = tipoServicoRepository.findById(id);
		if(tipoServico.isPresent()) {
			return ResponseEntity.ok(new DetalhesTipoServicoDto(tipoServico.get()));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TipoServicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTipoServicoForm form){
		Optional<TipoServico> optional = tipoServicoRepository.findById(id);
		if(optional.isPresent()) {
			TipoServico tipoServico = form.atualizar(id, tipoServicoRepository);
			return ResponseEntity.ok(new TipoServicoDto(tipoServico));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<TipoServico> optional = tipoServicoRepository.findById(id);
		if(optional.isPresent()) {
			tipoServicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
