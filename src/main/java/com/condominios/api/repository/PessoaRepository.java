package com.condominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condominios.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
