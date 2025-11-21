package com.ligabeisbolcartagena.main.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "temporadas")
public class Temporada {

    @Id
    private String id;

    private String nombreTemporada;
    private int anio;

    private List<Equipo> equiposParticipantes = new ArrayList<>();

    private List<Partido> partidosJugados = new ArrayList<>();
    
    private List<Estadio> estadios = new ArrayList<>();

    private Equipo equipoCampeon;

    private int totalPartidosJugados;

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreTemporada() {
        return nombreTemporada;
    }

    public void setNombreTemporada(String nombreTemporada) {
        this.nombreTemporada = nombreTemporada;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public List<Equipo> getEquiposParticipantes() {
        return equiposParticipantes;
    }

    public void setEquiposParticipantes(List<Equipo> equiposParticipantes) {
        this.equiposParticipantes = equiposParticipantes;
    }

    public List<Partido> getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(List<Partido> partidosJugados) {
        this.partidosJugados = partidosJugados;
    }
    
    public List<Estadio> getEstadios() {
        return estadios;
    }

    public void setEstadios(List<Estadio> estadios) {
        this.estadios = estadios;
    }

    public Equipo getEquipoCampeon() {
        return equipoCampeon;
    }

    public void setEquipoCampeon(Equipo equipoCampeon) {
        this.equipoCampeon = equipoCampeon;
    }

    public int getTotalPartidosJugados() {
        return totalPartidosJugados;
    }

    public void setTotalPartidosJugados(int totalPartidosJugados) {
        this.totalPartidosJugados = totalPartidosJugados;
    }
}

