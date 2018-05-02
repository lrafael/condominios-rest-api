package com.condominios.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.condominios.api.model.Condominio;
import com.condominios.api.repository.CondominioRepository;

@RestController
@RequestMapping("/condominios")
public class CondominioResource {
	
	@Autowired
	public CondominioRepository condominioRepository;
	
	@GetMapping
	public List<Condominio> listarCondominios(){
		return condominioRepository.findAll();
	}

}
