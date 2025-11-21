package com.ligabeisbolcartagena.main.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.ligabeisbolcartagena.main.model.JugadorLanzador;

public interface JugadorLanzadorRepository extends MongoRepository<JugadorLanzador, String> {
    
}
