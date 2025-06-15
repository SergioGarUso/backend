package com.mayagenda.backend.repository;

import com.mayagenda.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Cliente, Long> {
}
