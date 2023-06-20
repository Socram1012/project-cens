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
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sello_id")
    private Sello sello;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "entidad_evaluadora_id")
    private EntidadEvaluadora entidadEvaluadora;
    @OneToMany(mappedBy = "ambito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Subambito> subambitos = new ArrayList<>();
    public Ambito() { }
    public Ambito(String nombre, Sello sello, EntidadEvaluadora entidadEvaluadora) {

        this.nombre = nombre;
        this.sello = sello;
        this.entidadEvaluadora = entidadEvaluadora;

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

    public Sello getSello() { return sello; }

    public void setSello(Sello sello) { this.sello = sello; }

    public EntidadEvaluadora getEntidadEvaluadora() { return entidadEvaluadora; }

    public void setEntidadEvaluadora(EntidadEvaluadora entidadEvaluadora) { this.entidadEvaluadora = entidadEvaluadora; }

    public List<Subambito> getSubambitos() { return subambitos; }

    public void setSubambitos(List<Subambito> subambitos) { this.subambitos = subambitos; }
}
