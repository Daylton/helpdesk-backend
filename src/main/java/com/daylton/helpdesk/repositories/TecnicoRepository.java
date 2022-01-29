package com.daylton.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daylton.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
