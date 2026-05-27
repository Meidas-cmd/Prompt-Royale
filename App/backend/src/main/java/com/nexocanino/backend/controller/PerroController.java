package com.nexocanino.backend.controller;

import com.nexocanino.backend.model.Perro;
import com.nexocanino.backend.service.PerroService;
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
@RequestMapping("/api/perros")
public class PerroController {

    private final PerroService perroService;

    public PerroController(PerroService perroService) {
        this.perroService = perroService;
    }

    @GetMapping
    public List<Perro> listarTodos() {
        return perroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Perro buscarPorId(@PathVariable Long id) {
        return perroService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Perro> crear(@RequestBody Perro perro) {
        Perro perroCreado = perroService.crear(perro);
        return ResponseEntity
                .created(URI.create("/api/perros/" + perroCreado.getId()))
                .body(perroCreado);
    }

    @PutMapping("/{id}")
    public Perro actualizar(@PathVariable Long id, @RequestBody Perro perro) {
        return perroService.actualizar(id, perro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        perroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
