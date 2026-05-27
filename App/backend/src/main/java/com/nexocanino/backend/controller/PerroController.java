package com.nexocanino.backend.controller;

import com.nexocanino.backend.model.Perro;
import com.nexocanino.backend.service.PerroService;
import java.net.URI;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<?> listarTodos(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        if (page == null || size == null) {
            List<Perro> perros = perroService.listarTodos();
            return ResponseEntity.ok(perros);
        }

        Sort.Direction sortDirection = Sort.Direction.fromOptionalString(direction).orElse(Sort.Direction.ASC);
        return ResponseEntity.ok(perroService.listarPaginado(PageRequest.of(page, size, Sort.by(sortDirection, sort))));
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
