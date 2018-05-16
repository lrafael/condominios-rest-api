package com.condominios.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.condominios.api.model.Apartamento;
import com.condominios.api.repository.ApartamentoRepository;

@Service
public class ApartamentoService {

	@Autowired
	private ApartamentoRepository apartamentoRepository;

	public Apartamento atualizar(Long id, Apartamento ap) {
		Apartamento apartamentoaSalvo = buscarPessoaPeloId(id);
		BeanUtils.copyProperties(ap, apartamentoaSalvo, "id");
		return apartamentoRepository.save(apartamentoaSalvo);	
	}

	public Apartamento buscarPessoaPeloId(Long id) {
		Apartamento apartamentoaSalvo = apartamentoRepository.findById(id).orElseThrow(
				() -> new EmptyResultDataAccessException(1));
		return apartamentoaSalvo;
	}
}
