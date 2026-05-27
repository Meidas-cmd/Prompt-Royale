package com.nexocanino.backend.dto;

import com.nexocanino.backend.model.Rol;
import com.nexocanino.backend.model.Usuario;

public class UsuarioResponse {

    private Long id;

    private String nombre;

    private String email;

    private Rol rol;

    public UsuarioResponse(Long id, String nombre, String email, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
    }

    public static UsuarioResponse from(Usuario usuario) {
        return new UsuarioResponse(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getRol());
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Rol getRol() {
        return rol;
    }
}
