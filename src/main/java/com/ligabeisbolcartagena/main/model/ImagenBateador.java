package com.ligabeisbolcartagena.main.model;

import jakarta.persistence.*;

@Entity
public class ImagenBateador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreJugador;

    @Lob
    private byte[] foto; // Aquí se guarda la imagen como BLOB

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreJugador() { return nombreJugador; }
    public void setNombreJugador(String nombreJugador) { this.nombreJugador = nombreJugador; }

    public byte[] getFoto() { return foto; }
    public void setFoto(byte[] foto) { this.foto = foto; }
}
