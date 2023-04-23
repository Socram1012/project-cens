package com.proyecto.cens.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usuario {
    @Getter@Setter
    private Long id;
    @Getter@Setter
    private String nombre;
    @Getter@Setter
    private String apellido;
    @Getter@Setter
    private String telefono;
    @Getter@Setter
    private String email;
    @Getter@Setter
    private String contrasena;


}
