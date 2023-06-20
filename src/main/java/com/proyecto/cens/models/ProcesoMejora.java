package com.proyecto.cens.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Entity
@Table(name = "proceso-mejora")
@ToString
@EqualsAndHashCode
public class ProcesoMejora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter@Column(name = "id")
    private Long id;

    @Getter@Setter@Column(name = "f_entrega_informe")
    private Date fechaEntregaInforme;

    @Getter@Setter@Column(name = "ultima_evidencia_entregada")
    private Date ultimaEvidenciaEntregada;

    @Getter@Setter@Column(name = "seguimiento")
    private Date seguimiento;

    @Getter@Setter@Column(name = "comentario")
    private String comentario;

    @Getter@Setter@Column(name = "pendiente_sello")
    private Float pendienteSello;

    @Getter@Setter@Column(name = "cumplimiento_sello")
    private Float cumplimientoSello;

    @Getter@Setter@Column(name = "integracion")
    private Boolean integracion;

    @Getter@Setter@Column(name = "cantidad_obs_total")
    private Integer cantidadObservacionesTotales;

    @Getter@Setter@Column(name = "obs_dimension_cens")
    private Integer observacionesDimensionesCens;

    @Getter@Setter@Column(name = "total_evaluacion_cens")
    private Integer totalEvaluacionesCens;

    @Getter@Setter@Column(name = "observacion_atf")
    private Integer observacionesAtf;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "proceso_sello_id")
    private ProcesoSello procesoSello;

    public ProcesoMejora() { }

    public ProcesoMejora(Long id, Date fechaEntregaInforme, Date ultimaEvidenciaEntregada,
                         Date seguimiento, String comentario, Float pendienteSello,
                         Float cumplimientoSello, Boolean integracion, Integer cantidadObservacionesTotales,
                         Integer observacionesDimensionesCens, Integer totalEvaluacionesCens, Integer observacionesAtf,
                         ProcesoSello procesoSello) {
        this.id = id;
        this.fechaEntregaInforme = fechaEntregaInforme;
        this.ultimaEvidenciaEntregada = ultimaEvidenciaEntregada;
        this.seguimiento = seguimiento;
        this.comentario = comentario;
        this.pendienteSello = pendienteSello;
        this.cumplimientoSello = cumplimientoSello;
        this.integracion = integracion;
        this.cantidadObservacionesTotales = cantidadObservacionesTotales;
        this.observacionesDimensionesCens = observacionesDimensionesCens;
        this.totalEvaluacionesCens = totalEvaluacionesCens;
        this.observacionesAtf = observacionesAtf;
        this.procesoSello = procesoSello;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getFechaEntregaInforme() { return fechaEntregaInforme; }

    public void setFechaEntregaInforme(Date fechaEntregaInforme) { this.fechaEntregaInforme = fechaEntregaInforme; }

    public Date getUltimaEvidenciaEntregada() { return ultimaEvidenciaEntregada; }

    public void setUltimaEvidenciaEntregada(Date ultimaEvidenciaEntregada) { this.ultimaEvidenciaEntregada = ultimaEvidenciaEntregada; }

    public Date getSeguimiento() { return seguimiento; }

    public void setSeguimiento(Date seguimiento) { this.seguimiento = seguimiento; }

    public String getComentario() { return comentario; }

    public void setComentario(String comentario) { this.comentario = comentario; }

    public Float getPendienteSello() { return pendienteSello; }

    public void setPendienteSello(Float pendienteSello) { this.pendienteSello = pendienteSello; }

    public Float getCumplimientoSello() { return cumplimientoSello; }

    public void setCumplimientoSello(Float cumplimientoSello) { this.cumplimientoSello = cumplimientoSello; }

    public Boolean getIntegracion() { return integracion; }

    public void setIntegracion(Boolean integracion) { this.integracion = integracion; }

    public Integer getCantidadObservacionesTotales() { return cantidadObservacionesTotales; }

    public void setCantidadObservacionesTotales(Integer cantidadObservacionesTotales) { this.cantidadObservacionesTotales = cantidadObservacionesTotales; }

    public Integer getObservacionesDimensionesCens() { return observacionesDimensionesCens; }

    public void setObservacionesDimensionesCens(Integer observacionesDimensionesCens) { this.observacionesDimensionesCens = observacionesDimensionesCens; }

    public Integer getTotalEvaluacionesCens() { return totalEvaluacionesCens; }

    public void setTotalEvaluacionesCens(Integer totalEvaluacionesCens) { this.totalEvaluacionesCens = totalEvaluacionesCens; }

    public Integer getObservacionesAtf() { return observacionesAtf; }

    public void setObservacionesAtf(Integer observacionesAtf) { this.observacionesAtf = observacionesAtf; }

    public ProcesoSello getProcesoSello() { return procesoSello; }

    public void setProcesoSello(ProcesoSello procesoSello) { this.procesoSello = procesoSello; }
}
