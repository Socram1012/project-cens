package com.proyecto.cens.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "proceso_mejora")
public class ProcesoMejora{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_entrega_informe")
    private Date fechaEntregaInforme;

    @Column(name = "ultima_evidencia_entregada")
    private String ultimaEvidenciaEntregada;

    @Column(name = "seguimiento")
    private String seguimiento;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "pendiente_sello")
    private boolean pendienteSello;

    @Column(name = "cumplimiento_sello")
    private boolean cumplimientoSello;

    @Column(name = "integracion")
    private Boolean integracion;

    @Column(name = "cantidad_obs_total")
    private Integer cantidadObsTotal;

    @Column(name = "obs_dimension_cens")
    private Integer obsDimensionCens;

    @Column(name = "total_evaluacion_cens")
    private Integer totalEvaluacionCens;

    @Column(name = "observacion_atf")
    private Integer observacionAtf;

    @Column(name = "total_evaluacion_atf")
    private Integer totalEvaluacionAtf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proceso_sello_id", referencedColumnName = "id")
    private ProcesoSello procesoSelloId;

}
