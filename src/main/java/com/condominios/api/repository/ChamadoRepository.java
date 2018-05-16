package com.condominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.condominios.api.model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {

}
