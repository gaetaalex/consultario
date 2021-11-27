package com.reabilitare.consultorio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reabilitare.consultorio.domain.Pedido;
import com.reabilitare.consultorio.repositories.PedidoRepository;
import com.reabilitare.consultorio.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	public PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
