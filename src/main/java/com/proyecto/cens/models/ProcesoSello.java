package com.proyecto.cens.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Entity
@Table(name = "proceso-sello")
@ToString
@EqualsAndHashCode
public class ProcesoSello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter@Column(name = "id")
    private Long id;

    @Getter@Setter@Column(name = "nombre_etapa")
    private String nombreEtapa;

    @Getter@Setter@Column(name = "fecha_nda")
    private Date fechaNda;

    @Getter@Setter@Column(name = "f_acceso_herramienta")
    private Date fechaAccesoHerramienta;

    @Getter@Setter@Column(name = "f_creacion_formulario")
    private Date fechaCreacionFormulario;

    @Getter@Setter@Column(name = "f_envio_formulario")
    private Date fechaEnvioFormulario;

    @Getter@Setter@Column(name = "fecha_demostracion")
    private Date fechaDemostracion;

    @Getter@Setter@Column(name = "f_ent_inf_evaluadores")
    private Date fechaEntregaInformeEvaluadores;

    @Getter@Setter@Column(name = "f_entrega_informe")
    private Date fechaEntregaInforme;

    @Getter@Setter@Column(name = "f_ent_evidencia_final")
    private Date fechaEntregaEvidenciaFinal;

    @Getter@Setter@Column(name = "f_ent_evidencia_fonasa")
    private Date fechaEntregaEvidenciaFonasa;

    @Getter@Setter@Column(name = "f_integracion_fonasa")
    private Date fechaIntegracionFonasa;

    @Getter@Setter@Column(name = "f_otorgamiento")
    private Date fechaOtorgamiento;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public ProcesoSello() { }

    public ProcesoSello(Long id, String nombreEtapa, Date fechaNda, Date fechaAccesoHerramienta,
                        Date fechaCreacionFormulario, Date fechaEnvioFormulario, Date fechaDemostracion,
                        Date fechaEntregaInformeEvaluadores, Date fechaEntregaInforme, Date fechaEntregaEvidenciaFinal,
                        Date fechaEntregaEvidenciaFonasa, Date fechaIntegracionFonasa, Date fechaOtorgamiento, Empresa empresa) {
        this.id = id;
        this.nombreEtapa = nombreEtapa;
        this.fechaNda = fechaNda;
        this.fechaAccesoHerramienta = fechaAccesoHerramienta;
        this.fechaCreacionFormulario = fechaCreacionFormulario;
        this.fechaEnvioFormulario = fechaEnvioFormulario;
        this.fechaDemostracion = fechaDemostracion;
        this.fechaEntregaInformeEvaluadores = fechaEntregaInformeEvaluadores;
        this.fechaEntregaInforme = fechaEntregaInforme;
        this.fechaEntregaEvidenciaFinal = fechaEntregaEvidenciaFinal;
        this.fechaEntregaEvidenciaFonasa = fechaEntregaEvidenciaFonasa;
        this.fechaIntegracionFonasa = fechaIntegracionFonasa;
        this.fechaOtorgamiento = fechaOtorgamiento;
        this.empresa = empresa;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombreEtapa() { return nombreEtapa; }

    public void setNombreEtapa(String nombreEtapa) { this.nombreEtapa = nombreEtapa; }

    public Date getFechaNda() { return fechaNda; }

    public void setFechaNda(Date fechaNda) { this.fechaNda = fechaNda; }

    public Date getFechaAccesoHerramienta() { return fechaAccesoHerramienta; }

    public void setFechaAccesoHerramienta(Date fechaAccesoHerramienta) { this.fechaAccesoHerramienta = fechaAccesoHerramienta; }

    public Date getFechaCreacionFormulario() { return fechaCreacionFormulario; }

    public void setFechaCreacionFormulario(Date fechaCreacionFormulario) { this.fechaCreacionFormulario = fechaCreacionFormulario; }

    public Date getFechaEnvioFormulario() { return fechaEnvioFormulario; }

    public void setFechaEnvioFormulario(Date fechaEnvioFormulario) { this.fechaEnvioFormulario = fechaEnvioFormulario; }

    public Date getFechaDemostracion() { return fechaDemostracion; }

    public void setFechaDemostracion(Date fechaDemostracion) { this.fechaDemostracion = fechaDemostracion; }

    public Date getFechaEntregaInformeEvaluadores() { return fechaEntregaInformeEvaluadores; }

    public void setFechaEntregaInformeEvaluadores(Date fechaEntregaInformeEvaluadores) { this.fechaEntregaInformeEvaluadores = fechaEntregaInformeEvaluadores; }

    public Date getFechaEntregaInforme() { return fechaEntregaInforme; }

    public void setFechaEntregaInforme(Date fechaEntregaInforme) { this.fechaEntregaInforme = fechaEntregaInforme; }

    public Date getFechaEntregaEvidenciaFinal() { return fechaEntregaEvidenciaFinal; }

    public void setFechaEntregaEvidenciaFinal(Date fechaEntregaEvidenciaFinal) { this.fechaEntregaEvidenciaFinal = fechaEntregaEvidenciaFinal; }

    public Date getFechaEntregaEvidenciaFonasa() { return fechaEntregaEvidenciaFonasa; }

    public void setFechaEntregaEvidenciaFonasa(Date fechaEntregaEvidenciaFonasa) { this.fechaEntregaEvidenciaFonasa = fechaEntregaEvidenciaFonasa; }

    public Date getFechaIntegracionFonasa() { return fechaIntegracionFonasa; }

    public void setFechaIntegracionFonasa(Date fechaIntegracionFonasa) { this.fechaIntegracionFonasa = fechaIntegracionFonasa; }

    public Date getFechaOtorgamiento() { return fechaOtorgamiento; }

    public void setFechaOtorgamiento(Date fechaOtorgamiento) { this.fechaOtorgamiento = fechaOtorgamiento; }

    public Empresa getEmpresa() { return empresa; }

    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
}
