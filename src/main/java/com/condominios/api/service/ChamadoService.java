package com.condominios.api.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.condominios.api.model.Chamado;
import com.condominios.api.model.Condominio;
import com.condominios.api.model.Pessoa;
import com.condominios.api.repository.ChamadoRepository;
import com.condominios.api.repository.CondominioRepository;
import com.condominios.api.repository.PessoaRepository;
import com.condominios.api.service.exception.RecursoInexistenteException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private CondominioRepository condominioRepository;


	public Chamado atualizar(Long id, @Valid Chamado chamado) {
		Chamado chamadoSalvo = buscarChamadoPeloId(id);
		BeanUtils.copyProperties(chamado, chamadoSalvo, "id");
		return chamadoRepository.save(chamadoSalvo);
	}

	public Chamado buscarChamadoPeloId(Long id) {
		Chamado chamadoSalvo = chamadoRepository.findById(id).orElseThrow(
				() -> new EmptyResultDataAccessException(1));
		return chamadoSalvo;
	}
	
	public Chamado salvar(@Valid Chamado chamado) {

		//verificar se pessoa(id) existe
		Pessoa pessoa = pessoaRepository.findById(chamado.getPessoa().getId())
				.orElseThrow(() -> new RecursoInexistenteException("Pessoa com id: " + 
						chamado.getPessoa().getId() + "inexistente."));
		
		//verificar se condominio(id) existe
		Condominio condominio = condominioRepository.findById(chamado.getCondominio().getId())
				.orElseThrow(() -> new RecursoInexistenteException("Condominio com id: " + 
						chamado.getCondominio().getId() + "inexistente."));
		
		chamado.setPessoa(pessoa);
		chamado.setCondominio(condominio);
		return chamadoRepository.save(chamado);
	}
}
