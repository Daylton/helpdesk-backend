package com.daylton.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daylton.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
