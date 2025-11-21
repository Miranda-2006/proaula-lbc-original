package com.ligabeisbolcartagena.main.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ligabeisbolcartagena.main.model.Temporada;
import com.ligabeisbolcartagena.main.repository.mongo.TemporadaRepository;
import com.ligabeisbolcartagena.main.service.WekaService;

@Controller
@RequestMapping("/prediccion")
public class PrediccionController {

    private final WekaService wekaService;
    
    @Autowired
    private TemporadaRepository temporadaRepository;


    public PrediccionController(WekaService wekaService) {
        this.wekaService = wekaService;
    }

    @GetMapping
    public String formulario(@RequestParam(value = "id", required = false) String id, Model model) {

        Temporada temporada;

        if (id != null) {
            temporada = temporadaRepository.findById(id).orElse(null);
        } else {
            List<Temporada> todas = temporadaRepository.findAll();
            temporada = todas.stream()
                             .max(Comparator.comparingInt(Temporada::getAnio))
                             .orElse(null);
        }

        if (temporada != null && temporada.getEquiposParticipantes() != null) {
            temporada.setEquiposParticipantes(
                temporada.getEquiposParticipantes().stream()
                    .filter(e -> !"Agentes Libres".equalsIgnoreCase(e.getNombre()))
                    .collect(Collectors.toList())
            );
        }

        model.addAttribute("temporada", temporada);
        model.addAttribute("equipos", temporada != null ? temporada.getEquiposParticipantes() : null);

        return "prediccion";
    }


    @PostMapping("/resultado")
    public String resultado(
    		@RequestParam(value = "id", required = false) String id,
            @RequestParam String localVisitante,
            @RequestParam double rachaUlt3,
            @RequestParam double promFavor,
            @RequestParam double promContra,
            @RequestParam String rivalFuerza,
            Model model
    ) {
    	Temporada temporada;
    	
    	 if (id != null) {
             temporada = temporadaRepository.findById(id).orElse(null);
         } else {
             List<Temporada> todas = temporadaRepository.findAll();
             temporada = todas.stream()
                              .max(Comparator.comparingInt(Temporada::getAnio))
                              .orElse(null);
         }

         if (temporada != null && temporada.getEquiposParticipantes() != null) {
             temporada.setEquiposParticipantes(
                 temporada.getEquiposParticipantes().stream()
                     .filter(e -> !"Agentes Libres".equalsIgnoreCase(e.getNombre()))
                     .collect(Collectors.toList())
             );
         }
         
    	model.addAttribute("temporada", temporada);
        model.addAttribute("equipos", temporada != null ? temporada.getEquiposParticipantes() : null);
    	
        try {
            String pred = wekaService.predecir(localVisitante, rachaUlt3, promFavor, promContra, rivalFuerza);

            // Normalizar la respuesta de Weka
            String normalizada = pred.trim().equalsIgnoreCase("si") ? "Si" : "No";

            model.addAttribute("prediccion", normalizada);

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "prediccion";
    }
    
    
    
}
