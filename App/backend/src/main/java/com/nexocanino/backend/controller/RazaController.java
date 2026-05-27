package com.nexocanino.backend.controller;

import com.nexocanino.backend.model.Perro;
import com.nexocanino.backend.service.RazaService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/razas")
public class RazaController {

    private final RazaService razaService;

    public RazaController(RazaService razaService) {
        this.razaService = razaService;
    }

    @GetMapping("/{id}/perros")
    public List<Perro> listarPerrosPorRaza(@PathVariable Long id) {
        return razaService.listarPerrosPorRaza(id);
    }
}
