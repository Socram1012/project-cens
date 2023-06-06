package com.proyecto.cens.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "usuario")
@ToString @EqualsAndHashCode
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter@Column(name = "id")
    private Long id;
    @Getter@Setter@Column(name ="nombre")
    private String nombre;
    @Getter@Setter@Column(name ="apellido")
    private String apellido;
    @Getter@Setter@Column(name ="telefono")
    private String telefono;
    @Getter@Setter@Column(name ="email")
    private String email;
    @Getter@Setter@Column(name ="contrasena")
    private String contrasena;
    @Getter@Setter@Column(name ="rol_id")
    private Long rol_id;


}
