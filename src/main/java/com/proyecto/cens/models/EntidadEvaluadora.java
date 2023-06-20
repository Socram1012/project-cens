package com.proyecto.cens.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "entidad_evaluadora")
@ToString
@EqualsAndHashCode
public class EntidadEvaluadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter @Column(name = "id")
    private Long id;
    @Getter@Setter@Column(name = "nombre")
    private String nombre;

    public EntidadEvaluadora() { }

    public EntidadEvaluadora(Long id, String nombre) { this.id = id; this.nombre = nombre; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

}
