package com.ligabeisbolcartagena.main.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ligabeisbolcartagena.main.model.ImagenEquipo;

public interface ImagenEquipoRepository extends JpaRepository<ImagenEquipo, Long> {
	ImagenEquipo findByNombreEquipo(String nombreEquipo);

}
