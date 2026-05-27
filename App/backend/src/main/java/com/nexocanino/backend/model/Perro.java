package com.nexocanino.backend.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Perro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer edad;

    @JsonAlias("tamaño")
    private String tamano;

    private String descripcion;

    private String foto;

    private Boolean disponible;

    @ManyToOne
    @JoinColumn(name = "raza_id")
    @JsonIgnoreProperties("perros")
    private Raza raza;

    public Perro() {
    }

    public Perro(
            Long id,
            String nombre,
            Integer edad,
            String tamano,
            String descripcion,
            String foto,
            Boolean disponible,
            Raza raza
    ) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.tamano = tamano;
        this.descripcion = descripcion;
        this.foto = foto;
        this.disponible = disponible;
        this.raza = raza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }
}
