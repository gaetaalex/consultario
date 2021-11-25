package com.reabilitare.consultorio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reabilitare.consultorio.domain.Categoria;
import com.reabilitare.consultorio.repositories.CategoriaRepository;

@Service
public class CategoriaCategory {
	
	@Autowired
	public CategoriaRepository repo;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
	return obj;
	}

}
