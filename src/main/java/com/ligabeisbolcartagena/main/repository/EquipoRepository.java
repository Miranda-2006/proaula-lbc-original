package com.ligabeisbolcartagena.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ligabeisbolcartagena.main.model.Equipo;

public interface EquipoRepository extends MongoRepository<Equipo, String> {
}
