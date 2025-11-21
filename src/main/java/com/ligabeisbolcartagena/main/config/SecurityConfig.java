package com.ligabeisbolcartagena.main.config;

import com.ligabeisbolcartagena.main.service.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/mineria", "/listar-partidos/**", "/registro/**", "/perfil-bateador/**", "/perfil-lanzador/**", "/jugador-lanzador/**", "/jugador-bateador/**", "/temporadas/**", "/jugadores", "/favicon.ico", "/equipos/**", "/index", "/css/**", "/js/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
            	    .loginPage("/login")
            	    .defaultSuccessUrl("/", true)
            	    .failureUrl("/login?error=true")
            	    .permitAll()
            	)
            	.oauth2Login(oauth2 -> oauth2
            	    .loginPage("/login")
            	    .defaultSuccessUrl("/", true)
            	)
            .logout(logout -> logout
                .logoutSuccessUrl("/cerrar-sesion")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
