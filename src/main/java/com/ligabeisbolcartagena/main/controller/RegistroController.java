package com.ligabeisbolcartagena.main.controller;

import com.ligabeisbolcartagena.main.model.Usuario;
import com.ligabeisbolcartagena.main.repository.mongo.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;

import java.util.List;

@Controller
public class RegistroController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistroController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(HttpServletRequest request, Model model) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        model.addAttribute("_csrf", csrfToken);
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@RequestParam String username,
                                   @RequestParam String password,
                                   Model model) {

        if (usuarioRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "El usuario ya existe");
            return "registro";
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(username);
        nuevoUsuario.setPassword(passwordEncoder.encode(password));
        nuevoUsuario.setRoles(List.of("USER"));
        usuarioRepository.save(nuevoUsuario);

        return "redirect:/login?registrado";
    }
}
