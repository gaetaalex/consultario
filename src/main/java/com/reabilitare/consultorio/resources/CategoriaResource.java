package com.reabilitare.consultorio.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reabilitare.consultorio.domain.Categoria;
import com.reabilitare.consultorio.services.CategoriaCategory;

@RestController
@RequestMapping(value="/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaCategory categoria;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Optional<Categoria> obj = categoria.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
