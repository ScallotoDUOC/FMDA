package com.microservicio.usuario.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservicio.usuario.Model.Usuario;
import com.microservicio.usuario.Repository.UsuarioRepository;

@Configuration
public class UsuarioConfig {

    @Bean
    CommandLineRunner cargarUsuarios(
            UsuarioRepository usuarioRepository) {

        return args -> {

            // Usuario Angel
            if (usuarioRepository.findByUsername("angel").isEmpty()) {

                Usuario angel = new Usuario();
                angel.setUsername("angel");
                angel.setEmail("angel@gmail.com");
                angel.setPassword("123456");
                angel.setRol("ADMIN");
                angel.setPartidaName("Liverpool Career");

                usuarioRepository.save(angel);
            }

            // Usuario Milton
            if (usuarioRepository.findByUsername("milton").isEmpty()) {

                Usuario milton = new Usuario();
                milton.setUsername("milton");
                milton.setEmail("milton@gmail.com");
                milton.setPassword("123456");
                milton.setRol("USER");
                milton.setPartidaName("Real Madrid Save");

                usuarioRepository.save(milton);
            }
        };
    }
}