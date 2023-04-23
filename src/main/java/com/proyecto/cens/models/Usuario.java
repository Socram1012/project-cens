package com.proyecto.cens.models;

import javax.persistence.Column;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String contrasena;
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setTelefono(telefono);
        usuario.setEmail(email);
        usuario.setContrasena(contrasena);
    }

}
