package com.condominios.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.condominios.api.model.Endereco;
import com.condominios.api.repository.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@GetMapping
	public List<Endereco> listarEnderecos() {
		return enderecoRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody Endereco endereco, HttpServletResponse response) {
		Endereco enderecoSalvo = enderecoRepository.save(endereco);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(enderecoSalvo.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(enderecoSalvo);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> buscarEnderecoPeloId(@PathVariable Long id) {
		Endereco endereco = enderecoRepository.findById(id).orElse(null);
		return endereco != null ? ResponseEntity.ok(endereco) : ResponseEntity.notFound().build();
	}

}
