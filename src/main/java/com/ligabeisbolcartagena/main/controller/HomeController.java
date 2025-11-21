package com.ligabeisbolcartagena.main.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ligabeisbolcartagena.main.model.Temporada;
import com.ligabeisbolcartagena.main.repository.mongo.TemporadaRepository;

@Controller
public class HomeController {

    @Autowired
    private TemporadaRepository temporadaRepository;

    @GetMapping("/")
    public String home(@RequestParam(value = "id", required = false) String id, Model model) {
        Temporada temporada;

        if (id != null) {
            temporada = temporadaRepository.findById(id).orElse(null);
        } else {
            List<Temporada> todas = temporadaRepository.findAll();
            temporada = todas.stream()
                             .max(Comparator.comparingInt(Temporada::getAnio))
                             .orElse(null);
        }

        // 🔽 Ordenar equipos por partidos ganados (descendente)
        if (temporada != null && temporada.getEquiposParticipantes() != null) {
            temporada.setEquiposParticipantes(
                temporada.getEquiposParticipantes().stream()
                    .sorted(Comparator.comparingInt(e -> -e.getPartidosGanados()))
                    .collect(Collectors.toList())
            );
        }

        List<Temporada> todasTemporadas = temporadaRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Temporada::getAnio).reversed())
                .collect(Collectors.toList());

        model.addAttribute("temporada", temporada);
        model.addAttribute("todasTemporadas", todasTemporadas);

        return "index";
    }


    @GetMapping("/mineria")
    public String mostrarPrediccion(Model model) {
        return "prediccion";
    }
    

}
