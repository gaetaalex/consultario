package com.reabilitare.consultorio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reabilitare.consultorio.domain.Servicos;
import com.reabilitare.consultorio.repositories.ServicosRepository;

@Service
public class ServicoService {
	
	@Autowired
	public ServicosRepository repo;
	
	public Optional<Servicos> buscar(Integer id) {
		Optional<Servicos> obj = repo.findById(id);
	return obj;
	}

}
