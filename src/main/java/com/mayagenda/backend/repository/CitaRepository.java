package com.mayagenda.backend.repository;

import com.mayagenda.backend.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    @Query("SELECT c FROM Cita c WHERE c.fecha = :fecha")
    List<Cita> findByFecha(LocalDate fecha);
}
