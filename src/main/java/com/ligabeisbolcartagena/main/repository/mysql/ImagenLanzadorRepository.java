package com.ligabeisbolcartagena.main.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ligabeisbolcartagena.main.model.ImagenLanzador;

public interface ImagenLanzadorRepository extends JpaRepository<ImagenLanzador, Long> {
	ImagenLanzador findByNombreLanzador(String nombreLanzador);

}
