package com.ligabeisbolcartagena.main.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ligabeisbolcartagena.main.model.Temporada;

@Repository
public interface TemporadaRepository extends MongoRepository<Temporada, String> {
	List<Temporada> findByAnio(int anio);
}

