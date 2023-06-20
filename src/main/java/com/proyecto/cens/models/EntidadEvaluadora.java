package com.proyecto.cens.models;

import jakarta.persistence.*;

@Entity
@Table(name = "entidad_evaluadora")
public class EntidadEvaluadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public EntidadEvaluadora(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public EntidadEvaluadora() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
