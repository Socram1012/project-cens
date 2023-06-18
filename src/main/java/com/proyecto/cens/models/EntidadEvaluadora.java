package com.proyecto.cens.models;

import jakarta.persistence.*;

@Entity
@Table(name = "entidad_evaluadora")
public class EntidadEvaluadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;


}
