package com.ligabeisbolcartagena.main.model;

import jakarta.persistence.*;

@Entity
public class ImagenLanzador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreLanzador;

    @Lob
    private byte[] fotoLanzador; // Aquí se guarda la imagen como BLOB

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreLanzador() {
		return nombreLanzador;
	}

	public void setNombreLanzador(String nombreLanzador) {
		this.nombreLanzador = nombreLanzador;
	}

	public byte[] getFotoLanzador() {
		return fotoLanzador;
	}

	public void setFotoLanzador(byte[] fotoLanzador) {
		this.fotoLanzador = fotoLanzador;
	}
    
    
    
}
