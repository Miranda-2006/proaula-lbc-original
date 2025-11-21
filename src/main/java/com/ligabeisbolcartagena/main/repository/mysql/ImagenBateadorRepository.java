package com.ligabeisbolcartagena.main.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ligabeisbolcartagena.main.model.ImagenBateador;

public interface ImagenBateadorRepository extends JpaRepository<ImagenBateador, Long> {
	ImagenBateador findByNombreJugador(String nombreJugador);

}
