package com.daylton.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daylton.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
