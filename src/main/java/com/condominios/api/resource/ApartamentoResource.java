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

import com.condominios.api.model.Apartamento;
import com.condominios.api.repository.ApartamentoRepository;

@RestController
@RequestMapping("/apartamentos")
public class ApartamentoResource {

	@Autowired
	private ApartamentoRepository apartamentoRepository;

	@GetMapping
	public List<Apartamento> listarApartamentos() {
		return apartamentoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Apartamento> buscarApartamentoPeloId(@PathVariable Long id) {
		Apartamento apartamento = apartamentoRepository.findById(id).orElse(null);
		return apartamento != null ? ResponseEntity.ok(apartamento) : ResponseEntity.notFound().build();
	}
	

	@PostMapping
	public ResponseEntity<Apartamento> cadastrarApartamento(@RequestBody Apartamento apartamento,
			HttpServletResponse response) {
		Apartamento apartamentoSalvo = apartamentoRepository.save(apartamento);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(apartamentoSalvo.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(apartamentoSalvo);
	}
	


}
