package com.condominios.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.condominios.api.model.Apartamento;
import com.condominios.api.repository.ApartamentoRepository;
import com.condominios.api.service.ApartamentoService;

@RestController
@RequestMapping("/apartamentos")
public class ApartamentoResource {

	@Autowired
	private ApartamentoRepository apartamentoRepository;
	
	@Autowired
	private ApartamentoService apartamentoService;

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
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerApartamento(@PathVariable Long id) {
		apartamentoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Apartamento> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Apartamento apartamento) {
		
		return ResponseEntity.ok(apartamentoService.atualizar(id, apartamento));
	}


}
