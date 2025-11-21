package com.ligabeisbolcartagena.main.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ligabeisbolcartagena.main.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByUsername(String username);
}
