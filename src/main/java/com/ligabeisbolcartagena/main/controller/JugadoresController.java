package com.ligabeisbolcartagena.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ligabeisbolcartagena.main.model.Equipo;
import com.ligabeisbolcartagena.main.model.ImagenBateador;
import com.ligabeisbolcartagena.main.model.ImagenLanzador;
import com.ligabeisbolcartagena.main.model.JugadorBateador;
import com.ligabeisbolcartagena.main.model.JugadorLanzador;
import com.ligabeisbolcartagena.main.model.Temporada;
import com.ligabeisbolcartagena.main.repository.mongo.TemporadaRepository;
import com.ligabeisbolcartagena.main.repository.mysql.ImagenBateadorRepository;
import com.ligabeisbolcartagena.main.repository.mysql.ImagenLanzadorRepository;

@Controller
public class JugadoresController {

    private final TemporadaRepository temporadaRepository;

    public JugadoresController(TemporadaRepository temporadaRepository) {
        this.temporadaRepository = temporadaRepository;
    }

    @GetMapping("/temporadas-jugadores")
    public String mostrarTemporadasJugadores(Model model) {
        model.addAttribute("temporadas", temporadaRepository.findAll());
        return "temporadas_jugadores";
    }
    
    @GetMapping("/temporadas-jugadores/{idTemporada}")
    public String listarJugadoresPorTemporada(@PathVariable String idTemporada, Model model) {
        Temporada temporada = temporadaRepository.findById(idTemporada)
            .orElseThrow(() -> new IllegalArgumentException("Temporada no encontrada"));

        model.addAttribute("temporada", temporada);
        return "listar_jugadores_inicio";
    }
    
    @GetMapping("/perfil-bateador/{idTemporada}/{indexEquipo}/{indexBateador}")
    public String perfilBateadorUsuario(@PathVariable String idTemporada, @PathVariable int indexEquipo, @PathVariable int indexBateador, Model model) {
        Temporada temporada = temporadaRepository.findById(idTemporada).orElseThrow();
        Equipo equipo = temporada.getEquiposParticipantes().get(indexEquipo);
        JugadorBateador bateador = equipo.getBateadores().get(indexBateador);

        model.addAttribute("bateador", bateador);
        return "perfil_bateador_usuario";
    }
    
    @GetMapping("/perfil-lanzador/{idTemporada}/{indexEquipo}/{indexLanzador}")
    public String perfilLanzadorUsuario(@PathVariable String idTemporada, @PathVariable int indexEquipo, @PathVariable int indexLanzador, Model model) {
        Temporada temporada = temporadaRepository.findById(idTemporada).orElseThrow();
        Equipo equipo = temporada.getEquiposParticipantes().get(indexEquipo);
        JugadorLanzador lanzador = equipo.getLanzadores().get(indexLanzador);

        model.addAttribute("lanzador", lanzador);
        return "perfil_lanzador_usuario";
    }
    
    @Autowired
    private ImagenBateadorRepository imagenBateadorRepository;
    
    @GetMapping("/jugador-bateador/foto/{nombre}")
    public ResponseEntity<byte[]> mostrarFotoBateador(@PathVariable String nombre) {
        ImagenBateador img = imagenBateadorRepository.findByNombreJugador(nombre);
        if (img == null || img.getFoto() == null) {
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.IMAGE_PNG); // cambiar si es PNG
        return new ResponseEntity<>(img.getFoto(), headers, HttpStatus.OK);
    }
    
    
    @Autowired
    private ImagenLanzadorRepository imagenLanzadorRepository;
    
    @GetMapping("/jugador-lanzador/foto/{nombre}")
    public ResponseEntity<byte[]> mostrarFotoLanzador(@PathVariable String nombre) {
        ImagenLanzador img = imagenLanzadorRepository.findByNombreLanzador(nombre);
        if (img == null || img.getFotoLanzador() == null) {
            return ResponseEntity.notFound().build();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // o IMAGE_PNG si usas PNG
        return new ResponseEntity<>(img.getFotoLanzador(), headers, HttpStatus.OK);
    }


}

