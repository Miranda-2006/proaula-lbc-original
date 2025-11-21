package com.ligabeisbolcartagena.main.service;

import com.ligabeisbolcartagena.main.model.Equipo;
import com.ligabeisbolcartagena.main.repository.mongo.EquipoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    // Obtener todos los equipos
    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoRepository.findAll();
    }

    // Obtener un equipo por ID
    public Equipo obtenerEquipoPorId(String id) {
        Optional<Equipo> equipo = equipoRepository.findById(id);
        return equipo.orElse(null); // Retorna el equipo si existe, o null si no lo encuentra
    }

    // Guardar un equipo (crear o actualizar)
    public void guardarEquipo(Equipo equipo) {
        equipoRepository.save(equipo);
    }

    // Eliminar un equipo por ID
    public void eliminarEquipo(String id) {
        equipoRepository.deleteById(id);
    }
}
