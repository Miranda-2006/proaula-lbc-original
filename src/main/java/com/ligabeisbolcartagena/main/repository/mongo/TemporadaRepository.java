package com.ligabeisbolcartagena.main.repository.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ligabeisbolcartagena.main.model.Temporada;

@Repository
public interface TemporadaRepository extends MongoRepository<Temporada, String> {
    List<Temporada> findAllByOrderByAnioAsc();
    List<Temporada> findByAnio(int anio);
    List<Temporada> findByNombreTemporadaContainingIgnoreCase(String nombre);
}
