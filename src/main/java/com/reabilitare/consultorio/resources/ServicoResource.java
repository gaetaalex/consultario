package com.reabilitare.consultorio.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reabilitare.consultorio.domain.Servicos;
import com.reabilitare.consultorio.services.ServicoService;

@RestController
@RequestMapping(value="/servico")
public class ServicoResource {
	
	@Autowired
	private ServicoService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Optional<Servicos> obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
