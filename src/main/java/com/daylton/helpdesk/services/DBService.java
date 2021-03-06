package com.daylton.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.daylton.helpdesk.domain.Chamado;
import com.daylton.helpdesk.domain.Cliente;
import com.daylton.helpdesk.domain.Tecnico;
import com.daylton.helpdesk.domain.enums.Perfil;
import com.daylton.helpdesk.domain.enums.Prioridade;
import com.daylton.helpdesk.domain.enums.Status;
import com.daylton.helpdesk.repositories.ChamadoRepository;
import com.daylton.helpdesk.repositories.ClienteRepository;
import com.daylton.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Daylton", "69503275016", "daylton@email.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		
		Tecnico tec2 = new Tecnico(null, "Pedro", "54180045060", "pedro@email.com", encoder.encode("123"));

		Cliente cli1 = new Cliente(null, "Bruno Silva", "36836614025", "bruno@email.com", encoder.encode("123"));
		
//		Cliente cli2 = new Cliente(null, "Pedro Sampaio", "63421768099", "pedro@email.com", "345");

		Chamado c1 = new Chamado(
				null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		Chamado c2 = new Chamado(
				null,Prioridade.BAIXA, Status.ABERTO, "Chamado 02", "Segundo chamado",tec2, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1, c2));
	}
}
