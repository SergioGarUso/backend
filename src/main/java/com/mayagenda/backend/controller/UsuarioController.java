package com.mayagenda.backend.controller;

import com.mayagenda.backend.entity.Cliente;
import com.mayagenda.backend.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Cliente> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Cliente crearUsuario(@RequestBody Cliente usuario) {
        return usuarioRepository.save(usuario);
    }
}
