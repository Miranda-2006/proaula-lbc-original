package com.ligabeisbolcartagena.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

import java.util.*;

@Document(collection = "equipos")
public class Equipo {
    @Id
    private String id;
    private String nombre;
    private String ciudad;
    private int partidosGanados;
    private int partidosPerdidos;
    private List<JugadorBateador> bateadores = new ArrayList<>();
    private List<JugadorLanzador> lanzadores = new ArrayList<>();
    
    @Lob
    @Column(name = "foto_blob", columnDefinition = "LONGBLOB")
    private byte[] fotoEquipo;

    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getPartidosGanados() {
		return partidosGanados;
	}
	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}
	public List<JugadorBateador> getBateadores() {
		return bateadores;
	}
	public void setBateadores(List<JugadorBateador> bateadores) {
		this.bateadores = bateadores;
	}
	public List<JugadorLanzador> getLanzadores() {
		return lanzadores;
	}
	public void setLanzadores(List<JugadorLanzador> lanzadores) {
		this.lanzadores = lanzadores;
	}
	public byte[] getFotoEquipo() {
		return fotoEquipo;
	}
	public void setFotoEquipo(byte[] fotoEquipo) {
		this.fotoEquipo = fotoEquipo;
	}
	
}
