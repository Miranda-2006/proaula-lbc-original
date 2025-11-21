package com.ligabeisbolcartagena.main.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;

public class Partido {
    @Id
    private String id;
    private LocalDate fecha;
    private LocalTime hora;
    private Estadio estadio;
    private String nombreEquipoLocal;
    private String nombreEquipoVisitante;
    private int carrerasEquipoLocal;
    private int carrerasEquipoVisitante;
    private int innings;
    private int inningActual;
    private int hitTotalesPartido;
    private int erroresTotalesPartido;

    // Getters y setters

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
    public Estadio getEstadio() {
		return estadio;
	}
	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
	public String getNombreEquipoLocal() {
        return nombreEquipoLocal;
    }
    public void setNombreEquipoLocal(String nombreEquipoLocal) {
        this.nombreEquipoLocal = nombreEquipoLocal;
    }

    public String getNombreEquipoVisitante() {
        return nombreEquipoVisitante;
    }
    public void setNombreEquipoVisitante(String nombreEquipoVisitante) {
        this.nombreEquipoVisitante = nombreEquipoVisitante;
    }

    public int getCarrerasEquipoLocal() {
        return carrerasEquipoLocal;
    }
    public void setCarrerasEquipoLocal(int carrerasEquipoLocal) {
        this.carrerasEquipoLocal = carrerasEquipoLocal;
    }

    public int getCarrerasEquipoVisitante() {
        return carrerasEquipoVisitante;
    }
    public void setCarrerasEquipoVisitante(int carrerasEquipoVisitante) {
        this.carrerasEquipoVisitante = carrerasEquipoVisitante;
    }

    public int getInnings() {
        return innings;
    }
    public void setInnings(int innings) {
        this.innings = innings;
    }

    public int getInningActual() {
        return inningActual;
    }
    public void setInningActual(int inningActual) {
        this.inningActual = inningActual;
    }

    public int getHitTotalesPartido() {
        return hitTotalesPartido;
    }
    public void setHitTotalesPartido(int hitTotalesPartido) {
        this.hitTotalesPartido = hitTotalesPartido;
    }

    public int getErroresTotalesPartido() {
        return erroresTotalesPartido;
    }
    public void setErroresTotalesPartido(int erroresTotalesPartido) {
        this.erroresTotalesPartido = erroresTotalesPartido;
    }
}
