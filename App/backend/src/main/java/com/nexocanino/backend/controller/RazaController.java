package com.nexocanino.backend.controller;

import com.nexocanino.backend.model.Perro;
import com.nexocanino.backend.model.Raza;
import com.nexocanino.backend.service.RazaService;
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
    public ResponseEntity<?> listarPerrosPorRaza(
            @PathVariable Long id,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        if (page == null || size == null) {
            List<Perro> perros = razaService.listarPerrosPorRaza(id);
            return ResponseEntity.ok(perros);
        }

        Sort.Direction sortDirection = Sort.Direction.fromOptionalString(direction).orElse(Sort.Direction.ASC);
        return ResponseEntity.ok(razaService.listarPerrosPorRaza(id, PageRequest.of(page, size, Sort.by(sortDirection, sort))));
    }
}
