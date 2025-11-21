package com.ligabeisbolcartagena.main.config;

import com.ligabeisbolcartagena.main.model.Usuario;
import com.ligabeisbolcartagena.main.repository.mongo.UsuarioRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DataInitializer {

	@Bean
	CommandLineRunner initUsuarios(UsuarioRepository repo, PasswordEncoder encoder) {
	    return args -> {
	        if (repo.findByUsername("adminlbc").isEmpty()) {
	            Usuario admin = new Usuario();
	            admin.setUsername("adminlbc");
	            admin.setPassword(encoder.encode("adminlbc2025"));
	            admin.setRoles(List.of("ADMIN"));
	            repo.save(admin);
	            System.out.println("✅ Usuario admin creado.");
	        }
	    };
	}
}
