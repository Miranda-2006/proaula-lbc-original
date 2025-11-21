package com.ligabeisbolcartagena.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ligabeisbolcartagena.main.model.Temporada;
import com.ligabeisbolcartagena.main.repository.mongo.TemporadaRepository;

@Controller
public class PartidosController {
	
	private final TemporadaRepository temporadaRepository;

    public PartidosController(TemporadaRepository temporadaRepository) {
        this.temporadaRepository = temporadaRepository;
    }

	@GetMapping("/listar-partidos")
    public String listarPartidosUsuario(Model model) {
        List<Temporada> temporadas = temporadaRepository.findAll();
        model.addAttribute("temporadas", temporadas);
        return "listar_partidos";
    }
	
	
}
