package com.proyecto.cens.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "nota")
@ToString @EqualsAndHashCode
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter@Column(name = "id")
    private Long id;
    @Getter@Setter@Column(name = "calificacion")
    private Integer calificacion;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "proceso_sello_id")
    private ProcesoSello procesoSello;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subambito_id")
    private Subambito subambito;

    public Nota() { }

    public Nota(Integer calificacion, ProcesoSello procesoSello, Subambito subambito) {
        this.calificacion = calificacion;
        this.procesoSello = procesoSello;
        this.subambito = subambito;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getCalificacion() { return calificacion; }

    public void setCalificacion(Integer calificacion) { this.calificacion = calificacion; }

    public ProcesoSello getProcesoSello() { return procesoSello; }

    public void setProcesoSello(ProcesoSello procesoSello) { this.procesoSello = procesoSello; }

}
