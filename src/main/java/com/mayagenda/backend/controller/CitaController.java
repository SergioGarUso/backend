package com.mayagenda.backend.controller;

import com.mayagenda.backend.entity.Cita;
import com.mayagenda.backend.entity.Usuario;
import com.mayagenda.backend.repository.CitaRepository;
import com.mayagenda.backend.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        if (cita.getUsuario() != null && cita.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(cita.getUsuario().getId()).orElse(null);
            if (usuario != null) {
                cita.setUsuario(usuario);
                return ResponseEntity.ok(citaRepository.save(cita));
            }
        }
        return ResponseEntity.badRequest().build();
    }
}
