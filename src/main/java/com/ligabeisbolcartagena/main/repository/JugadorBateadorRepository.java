package com.ligabeisbolcartagena.main.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.ligabeisbolcartagena.main.model.JugadorBateador;

public interface JugadorBateadorRepository extends MongoRepository<JugadorBateador, String> {

}
