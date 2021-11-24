package com.reabilitare.consultorio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reabilitare.consultorio.domain.Servicos;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Integer> {

}
