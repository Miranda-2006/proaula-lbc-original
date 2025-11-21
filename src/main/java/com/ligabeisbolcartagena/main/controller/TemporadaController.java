package com.ligabeisbolcartagena.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ligabeisbolcartagena.main.model.Temporada;
import com.ligabeisbolcartagena.main.repository.mongo.TemporadaRepository;

import java.util.Optional;

//VISTA AUXILIAR

@Controller
public class TemporadaController {

    @Autowired
    private TemporadaRepository temporadaRepository;

    @GetMapping("/temporadas")
    public String listarTemporadas(Model model) {
        model.addAttribute("temporadas", temporadaRepository.findAll());
        return "temporadas";
    }

    @GetMapping("/temporadas/{idTemporada}")
    public String verEquiposDeTemporada(@PathVariable String idTemporada, Model model) {
        Optional<Temporada> temporadaOpt = temporadaRepository.findById(idTemporada);
        if (temporadaOpt.isPresent()) {
            Temporada temporada = temporadaOpt.get();
            model.addAttribute("temporada", temporada);
            model.addAttribute("equipos", temporada.getEquiposParticipantes());
            return "detalle_temporada";
        } else {
            return "redirect:/temporadas";
        }
    }
}
