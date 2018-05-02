package com.condominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condominios.api.model.Condominio;

public interface CondominioRepository extends JpaRepository<Condominio, Long>{

}
