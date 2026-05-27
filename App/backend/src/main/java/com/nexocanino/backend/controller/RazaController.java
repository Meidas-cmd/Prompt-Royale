package com.nexocanino.backend.controller;

import com.nexocanino.backend.model.Perro;
import com.nexocanino.backend.model.Raza;
import com.nexocanino.backend.service.RazaService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping
    public List<Raza> listarTodas() {
        return razaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Raza buscarPorId(@PathVariable Long id) {
        return razaService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Raza> crear(@RequestBody Raza raza) {
        Raza razaCreada = razaService.crear(raza);
        return ResponseEntity
                .created(URI.create("/api/razas/" + razaCreada.getId()))
                .body(razaCreada);
    }

    @PutMapping("/{id}")
    public Raza actualizar(@PathVariable Long id, @RequestBody Raza raza) {
        return razaService.actualizar(id, raza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        razaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/perros")
    public List<Perro> listarPerrosPorRaza(@PathVariable Long id) {
        return razaService.listarPerrosPorRaza(id);
    }
}
