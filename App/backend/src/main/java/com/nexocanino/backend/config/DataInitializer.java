package com.nexocanino.backend.config;

import com.nexocanino.backend.model.Rol;
import com.nexocanino.backend.model.Usuario;
import com.nexocanino.backend.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner crearUsuariosIniciales(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            if (!usuarioRepository.existsByEmail("admin@nexocanino.local")) {
                Usuario admin = new Usuario();
                admin.setNombre("Administrador");
                admin.setEmail("admin@nexocanino.local");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRol(Rol.ADMIN);
                usuarioRepository.save(admin);
            }

            if (!usuarioRepository.existsByEmail("user@nexocanino.local")) {
                Usuario user = new Usuario();
                user.setNombre("Usuario demo");
                user.setEmail("user@nexocanino.local");
                user.setPassword(passwordEncoder.encode("user123"));
                user.setRol(Rol.USER);
                usuarioRepository.save(user);
            }
        };
    }
}
