package com.proyecto.cens.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ambito")
@ToString @EqualsAndHashCode
public class Ambito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter@Column(name = "id")
    private Long id;
    @Getter@Setter@Column(name = "nombre")
    private String nombre;
    @Getter@Setter@Column(name = "sello_id")
    private String sello_id;
    @Getter@Setter@Column(name = "entidad_evaluadora_id")
    private String entidad_evaluadora_id;
    @OneToMany(mappedBy = "ambito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subambito> subambitos = new ArrayList<>();
    public Ambito() { }
    public Ambito(String nombre) {
        this.nombre = nombre;
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
