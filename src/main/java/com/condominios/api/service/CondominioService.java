package com.condominios.api.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.condominios.api.model.Condominio;
import com.condominios.api.model.Endereco;
import com.condominios.api.repository.CondominioRepository;
import com.condominios.api.repository.EnderecoRepository;
import com.condominios.api.service.exception.EnderecoInexistenteException;

@Service
public class CondominioService {

	@Autowired
	private CondominioRepository condominioRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Condominio atualizar(Long id, Condominio condominio) {
		Condominio condominioSalvo = buscarCondominioPeloId(id);
		
		//Verificar se o endereço(id) existe
		Endereco endereco = enderecoRepository.findById(
				condominio.getEndereco().getId()).orElse(null);
		if(endereco == null) {
			throw new EnderecoInexistenteException();
		}
		condominio.setEndereco(endereco);
		
		BeanUtils.copyProperties(condominio, condominioSalvo, "id");
		return condominioRepository.save(condominioSalvo);	
	}

	public Condominio buscarCondominioPeloId(Long id) {
		Condominio condominioSalvo = condominioRepository.findById(id).orElseThrow(
				() -> new EmptyResultDataAccessException(1));
		return condominioSalvo;
	}

	public Condominio salvar(@Valid Condominio condominio) {
		//Verificar se o endereço(id) existe
		Endereco endereco = enderecoRepository.findById(
				condominio.getEndereco().getId()).orElse(null);
		if(endereco == null) {
			throw new EnderecoInexistenteException();
		}
		condominio.setEndereco(endereco);
		return condominioRepository.save(condominio);
	}
}
