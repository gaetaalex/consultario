package com.reabilitare.consultorio;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reabilitare.consultorio.domain.Servicos;
import com.reabilitare.consultorio.repositories.ServicosRepository;

@SpringBootApplication
public class ConsultorioApplication implements CommandLineRunner {

	@Autowired
	private ServicosRepository servicosRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsultorioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Servicos ser1 = new Servicos(null,"Fisioterapia", 100, 1);
		Servicos ser2 = new Servicos(null,"Pilates", 50, 1);
		
		servicosRepository.saveAll(Arrays.asList(ser1, ser2));
		
	}

}
