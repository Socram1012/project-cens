package com.proyecto.cens.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "proceso_evaluacion")
@ToString@EqualsAndHashCode
public class ProcesoEvaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;
    @Getter@Setter@Column(name = "nombre")
    private String nombre;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ambito_id")
    private Ambito ambito;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "entidad_evaluadora_id")
    private EntidadEvaluadora entidadEvaluadora;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "proceso_sello_id")
    private ProcesoSello procesoSello;

    public ProcesoEvaluacion() { }

    public ProcesoEvaluacion(Long id, String nombre, Ambito ambito, EntidadEvaluadora entidadEvaluadora, ProcesoSello procesoSello) {
        this.id = id;
        this.nombre = nombre;
        this.ambito = ambito;
        this.entidadEvaluadora = entidadEvaluadora;
        this.procesoSello = procesoSello;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public Ambito getAmbito() { return ambito; }

    public void setAmbito(Ambito ambito) { this.ambito = ambito; }

    public EntidadEvaluadora getEntidadEvaluadora() { return entidadEvaluadora; }

    public void setEntidadEvaluadora(EntidadEvaluadora entidadEvaluadora) { this.entidadEvaluadora = entidadEvaluadora; }

    public ProcesoSello getProcesoSello() { return procesoSello; }

    public void setProcesoSello(ProcesoSello procesoSello) { this.procesoSello = procesoSello; }
}
