package com.daylton.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daylton.helpdesk.domain.Chamado;
import com.daylton.helpdesk.domain.Cliente;
import com.daylton.helpdesk.domain.Tecnico;
import com.daylton.helpdesk.domain.enums.Perfil;
import com.daylton.helpdesk.domain.enums.Prioridade;
import com.daylton.helpdesk.domain.enums.Status;
import com.daylton.helpdesk.repositories.ChamadoRepository;
import com.daylton.helpdesk.repositories.ClienteRepository;
import com.daylton.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Daylton", "69503275016", "daylton@email.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Bruno Silva", "36836614025", "bruno@email.com", "123");

		Chamado c1 = new Chamado(
				null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}











