package com.nexocanino.backend.repository;

import com.nexocanino.backend.model.Perro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerroRepository extends JpaRepository<Perro, Long> {

    List<Perro> findByRazaId(Long razaId);
}
