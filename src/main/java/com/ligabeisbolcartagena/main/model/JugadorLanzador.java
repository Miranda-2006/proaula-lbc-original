package com.ligabeisbolcartagena.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

@Document(collection = "jugadorLanzador")
public class JugadorLanzador {
    @Id
    private String id;
    private String nombre;
    private int edad;
    private String posicion;
    private String derecho_zurdo;
    private int numeroLanzamientos, inningsLanzados, ponchados;
    private int basePorBola, carrerasPermitidas, hitsPermitidos, aparicionesPlato;
    
    @Lob
    @Column(name = "foto_blob", columnDefinition = "LONGBLOB")
    private byte[] fotoLanzador;

    public double getERA() {
        return inningsLanzados == 0 ? 0 : (double) carrerasPermitidas * 9 / inningsLanzados;
    }

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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getNumeroLanzamientos() {
		return numeroLanzamientos;
	}

	public void setNumeroLanzamientos(int numeroLanzamientos) {
		this.numeroLanzamientos = numeroLanzamientos;
	}

	public int getInningsLanzados() {
		return inningsLanzados;
	}

	public void setInningsLanzados(int inningsLanzados) {
		this.inningsLanzados = inningsLanzados;
	}

	public int getPonchados() {
		return ponchados;
	}

	public void setPonchados(int ponchados) {
		this.ponchados = ponchados;
	}

	public int getBasePorBola() {
		return basePorBola;
	}

	public void setBasePorBola(int basePorBola) {
		this.basePorBola = basePorBola;
	}

	public int getCarrerasPermitidas() {
		return carrerasPermitidas;
	}

	public void setCarrerasPermitidas(int carrerasPermitidas) {
		this.carrerasPermitidas = carrerasPermitidas;
	}

	public int getHitsPermitidos() {
		return hitsPermitidos;
	}

	public void setHitsPermitidos(int hitsPermitidos) {
		this.hitsPermitidos = hitsPermitidos;
	}

	public int getAparicionesPlato() {
		return aparicionesPlato;
	}

	public void setAparicionesPlato(int aparicionesPlato) {
		this.aparicionesPlato = aparicionesPlato;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public String getDerecho_zurdo() {
		return derecho_zurdo;
	}

	public void setDerecho_zurdo(String derecho_zurdo) {
		this.derecho_zurdo = derecho_zurdo;
	}

	public byte[] getFotoLanzador() {
		return fotoLanzador;
	}

	public void setFotoLanzador(byte[] fotoLanzador) {
		this.fotoLanzador = fotoLanzador;
	}

	

    
	
}
