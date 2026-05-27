package com.nexocanino.backend.service;

import com.nexocanino.backend.model.Perro;
import com.nexocanino.backend.model.Raza;
import com.nexocanino.backend.repository.PerroRepository;
import com.nexocanino.backend.repository.RazaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class PerroService {

    private final PerroRepository perroRepository;
    private final RazaRepository razaRepository;

    public PerroService(PerroRepository perroRepository, RazaRepository razaRepository) {
        this.perroRepository = perroRepository;
        this.razaRepository = razaRepository;
    }

    public List<Perro> listarTodos() {
        return perroRepository.findAll();
    }

    public Perro buscarPorId(Long id) {
        return perroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Perro no encontrado con id " + id));
    }

    public Perro crear(Perro perro) {
        perro.setId(null);
        perro.setRaza(obtenerRazaGestionada(perro.getRaza()));
        return perroRepository.save(perro);
    }

    public Perro actualizar(Long id, Perro datosPerro) {
        Perro perro = buscarPorId(id);
        perro.setNombre(datosPerro.getNombre());
        perro.setEdad(datosPerro.getEdad());
        perro.setTamano(datosPerro.getTamano());
        perro.setDescripcion(datosPerro.getDescripcion());
        perro.setFoto(datosPerro.getFoto());
        perro.setDisponible(datosPerro.getDisponible());
        perro.setRaza(obtenerRazaGestionada(datosPerro.getRaza()));
        return perroRepository.save(perro);
    }

    public void eliminar(Long id) {
        Perro perro = buscarPorId(id);
        perroRepository.delete(perro);
    }

    private Raza obtenerRazaGestionada(Raza raza) {
        if (raza == null || raza.getId() == null) {
            return null;
        }

        return razaRepository.findById(raza.getId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Raza no encontrada con id " + raza.getId()));
    }
}
