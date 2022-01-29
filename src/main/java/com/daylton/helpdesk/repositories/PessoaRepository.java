package com.daylton.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daylton.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
