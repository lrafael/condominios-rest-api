package com.condominios.api.resource;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.condominios.api.model.Pessoa;
import com.condominios.api.model.Sexo;
import com.condominios.api.repository.PessoaRepository;
import com.condominios.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private PessoaService pessoaService;

	/**
	 * Retorna a lista de pessoas
	 * 
	 * @return
	 */
	@GetMapping
	public List<Pessoa> listarPessoas() {
		return pessoaRepository.findAll();
	}

	/**
	 * Retorna a pessoa com o id indicado ou null caso não exista
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Pessoa buscarPessoaId(@PathVariable Long id) {
		return pessoaRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	/**
	 * Adiciona uma nova pessoa na base de dados, retorna o endenreço(url) para
	 * acessar o recurso salvo e retorna cogigo 201 em caso sucesso
	 * 
	 * @param pessoa
	 * @param response
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(pessoa.getId())
				.toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

	/**
	 * Remove a pessoa com o id indicado
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerPessoa(@PathVariable Long id) {
		pessoaRepository.deleteById(id);
	}

	/**
	 * Atualiza um objeto pessoa
	 * 
	 * @param id
	 * @param pessoa
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
		return ResponseEntity.ok(pessoaService.atualizar(id, pessoa));
	}

	/**
	 * Retorna a lista de sexos
	 * 
	 */
	@GetMapping("/sexos")
	public List<Sexo> listarSexos() {
		return Arrays.asList(Sexo.values());
	}

}
