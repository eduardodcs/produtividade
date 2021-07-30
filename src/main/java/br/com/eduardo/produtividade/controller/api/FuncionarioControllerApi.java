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

import br.com.eduardo.produtividade.controller.dto.DetalhesFuncionarioDto;
import br.com.eduardo.produtividade.controller.dto.FuncionarioDto;
import br.com.eduardo.produtividade.controller.form.AtualizacaoFuncionarioForm;
import br.com.eduardo.produtividade.controller.form.FuncionarioForm;
import br.com.eduardo.produtividade.modelo.Funcionario;
import br.com.eduardo.produtividade.repository.FuncionarioRepository;


@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioControllerApi {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@GetMapping
	public Page<FuncionarioDto> lista(@RequestParam(required= false) String nomeFuncionario,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
		if(nomeFuncionario == null) {
			Page<Funcionario> funcionario = funcionarioRepository.findAll(paginacao);
			return FuncionarioDto.converter(funcionario);
		} else {
			Page<Funcionario> funcionario = funcionarioRepository.findByNome(nomeFuncionario, paginacao);
			return FuncionarioDto.converter(funcionario);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<FuncionarioDto> cadastrar(@RequestBody @Valid FuncionarioForm form, UriComponentsBuilder uriBuilder){
		Funcionario funcionario = form.converter();
		funcionarioRepository.save(funcionario);
		
		URI uri = uriBuilder.path("/api/tipo-servico/{id}").buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).body(new FuncionarioDto(funcionario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesFuncionarioDto> detalhar(@PathVariable Long id){
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if(funcionario.isPresent()) {
			return ResponseEntity.ok(new DetalhesFuncionarioDto(funcionario.get()));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FuncionarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoFuncionarioForm form){
		Optional<Funcionario> optional = funcionarioRepository.findById(id);
		if(optional.isPresent()) {
			Funcionario funcionario = form.atualizar(id, funcionarioRepository);
			return ResponseEntity.ok(new FuncionarioDto(funcionario));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		Optional<Funcionario> optional = funcionarioRepository.findById(id);
		if(optional.isPresent()) {
			funcionarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
