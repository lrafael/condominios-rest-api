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

import com.condominios.api.model.Condominio;
import com.condominios.api.repository.CondominioRepository;
import com.condominios.api.service.CondominioService;

@RestController
@RequestMapping("/condominios")
public class CondominioResource {
	
	@Autowired
	private CondominioRepository condominioRepository;
	
	@Autowired
	private CondominioService condominioService;
	
	@GetMapping
	public List<Condominio> listarCondominios(){
		return condominioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Condominio buscarPeloId(@PathVariable Long id) {
		return condominioRepository.findById(id).orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<Condominio> criar(@Valid @RequestBody Condominio condominio, 
			HttpServletResponse response) {
		
		Condominio condominioSalvo = condominioService.salvar(condominio);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
				path("/{id}").buildAndExpand(condominio.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.status(HttpStatus.CREATED).body(condominioSalvo);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerCondominio(@PathVariable Long id) {
		condominioRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Condominio> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Condominio condominio) {
		return ResponseEntity.ok(condominioService.atualizar(id, condominio));
	}

}
