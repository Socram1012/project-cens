package com.proyecto.cens.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter@Column(name = "id")
    private Long id;
    @Getter@Setter@Column(name = "rut_empresa")
    private String rut_empresa;
    @Getter@Setter@Column(name = "razon_social")
    private String razon_social;
    @Getter@Setter@Column(name = "fecha_ingreso")
    private Date fecha_ingreso;
}
