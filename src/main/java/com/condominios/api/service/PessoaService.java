package com.condominios.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.condominios.api.model.Pessoa;
import com.condominios.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPeloId(id);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return pessoaRepository.save(pessoaSalva);	
	}

	public Pessoa buscarPessoaPeloId(Long id) {
		Pessoa pessoaSalva = pessoaRepository.findById(id).orElseThrow(
				() -> new EmptyResultDataAccessException(1));
		return pessoaSalva;
	}
}
