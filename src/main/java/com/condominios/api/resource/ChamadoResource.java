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
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.condominios.api.model.Chamado;
import com.condominios.api.model.Criticidade;
import com.condominios.api.repository.ChamadoRepository;
import com.condominios.api.service.ChamadoService;

@CrossOrigin
@RestController
@RequestMapping("/chamados")
public class ChamadoResource {
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private ChamadoService chamadoService;

	@GetMapping
	public List<Chamado> listar() {
		return chamadoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Chamado buscarPeloId(@PathVariable Long id) {
		return chamadoRepository.findById(id).orElseThrow(
				() -> new EmptyResultDataAccessException(1));
	}
	
	@PostMapping
	public ResponseEntity<Chamado> criar(@Valid @RequestBody Chamado chamado, 
			HttpServletResponse response) {
		
		Chamado chamadoSalvo = chamadoService.salvar(chamado);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
				path("/{id}").buildAndExpand(chamado.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.status(HttpStatus.CREATED).body(chamadoSalvo);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerChamado(@PathVariable Long id) {
		chamadoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Chamado> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Chamado chamado) {
		return ResponseEntity.ok(chamadoService.atualizar(id, chamado));
	}
	
	@GetMapping("/criticidades")
	public List<Criticidade> listarCriticidades() {
		return Arrays.asList(Criticidade.values());
	}

}
