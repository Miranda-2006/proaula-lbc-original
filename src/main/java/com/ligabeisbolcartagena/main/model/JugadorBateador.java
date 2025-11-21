package com.ligabeisbolcartagena.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

@Document(collection = "jugadorBateador")
public class JugadorBateador {
    @Id
    private String id;
    private String nombre;
    private int edad;
    private String posicion;
    private String derecho_zurdo;
    private int homeRuns, triples, dobles, sencillos;
    private int basePorBola, basePorGolpe, ponches;
    private int roboDeBase, carrerasImpulsadas, errores;
    
    @Lob
    @Column(name = "foto_blob", columnDefinition = "LONGBLOB")
    private byte[] foto;



    public int getTurnosAlBate() {
        return homeRuns + triples + dobles + sencillos + ponches;
    }

    public double getPromedioBateo() {
        int turnos = getTurnosAlBate();
        return turnos == 0 ? 0 : (double) (homeRuns + triples + dobles + sencillos) / turnos;
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

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getHomeRuns() {
		return homeRuns;
	}

	public void setHomeRuns(int homeRuns) {
		this.homeRuns = homeRuns;
	}

	public int getTriples() {
		return triples;
	}

	public void setTriples(int triples) {
		this.triples = triples;
	}

	public int getDobles() {
		return dobles;
	}

	public void setDobles(int dobles) {
		this.dobles = dobles;
	}

	public int getSencillos() {
		return sencillos;
	}

	public void setSencillos(int sencillos) {
		this.sencillos = sencillos;
	}

	public int getBasePorBola() {
		return basePorBola;
	}

	public void setBasePorBola(int basePorBola) {
		this.basePorBola = basePorBola;
	}

	public int getBasePorGolpe() {
		return basePorGolpe;
	}

	public void setBasePorGolpe(int basePorGolpe) {
		this.basePorGolpe = basePorGolpe;
	}

	public int getPonches() {
		return ponches;
	}

	public void setPonches(int ponches) {
		this.ponches = ponches;
	}

	public int getRoboDeBase() {
		return roboDeBase;
	}

	public void setRoboDeBase(int roboDeBase) {
		this.roboDeBase = roboDeBase;
	}

	public int getCarrerasImpulsadas() {
		return carrerasImpulsadas;
	}

	public void setCarrerasImpulsadas(int carrerasImpulsadas) {
		this.carrerasImpulsadas = carrerasImpulsadas;
	}

	public int getErrores() {
		return errores;
	}

	public void setErrores(int errores) {
		this.errores = errores;
	}

	public String getDerecho_zurdo() {
		return derecho_zurdo;
	}

	public void setDerecho_zurdo(String derecho_zurdo) {
		this.derecho_zurdo = derecho_zurdo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}


	
}
