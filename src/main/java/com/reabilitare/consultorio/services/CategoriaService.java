package com.reabilitare.consultorio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reabilitare.consultorio.domain.Categoria;
import com.reabilitare.consultorio.repositories.CategoriaRepository;
import com.reabilitare.consultorio.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	public CategoriaRepository repo;
	
	public Optional<Categoria> buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id" + id
					+ ", Tipo: " + Categoria.class.getName());
		}
	return obj;
	}

}
