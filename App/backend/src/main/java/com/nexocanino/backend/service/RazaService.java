package com.nexocanino.backend.service;

import com.nexocanino.backend.model.Perro;
import com.nexocanino.backend.model.Raza;
import com.nexocanino.backend.repository.PerroRepository;
import com.nexocanino.backend.repository.RazaRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class RazaService {

    private final RazaRepository razaRepository;
    private final PerroRepository perroRepository;

    public RazaService(RazaRepository razaRepository, PerroRepository perroRepository) {
        this.razaRepository = razaRepository;
        this.perroRepository = perroRepository;
    }

    public List<Raza> listarTodas() {
        return razaRepository.findAll();
    }

    public Raza buscarPorId(Long id) {
        return razaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Raza no encontrada con id " + id));
    }

    public Raza crear(Raza raza) {
        raza.setId(null);
        return razaRepository.save(raza);
    }

    public Raza actualizar(Long id, Raza datosRaza) {
        Raza raza = buscarPorId(id);
        raza.setNombre(datosRaza.getNombre());
        raza.setDescripcion(datosRaza.getDescripcion());
        return razaRepository.save(raza);
    }

    public void eliminar(Long id) {
        Raza raza = buscarPorId(id);
        razaRepository.delete(raza);
    }

    public List<Perro> listarPerrosPorRaza(Long razaId) {
        buscarPorId(razaId);
        return perroRepository.findByRazaId(razaId);
    }

    public Page<Perro> listarPerrosPorRaza(Long razaId, Pageable pageable) {
        buscarPorId(razaId);
        return perroRepository.findByRazaId(razaId, pageable);
    }
}
