package com.proyecto.cens.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "proceso_sello")
public class ProcesoSello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_etapa")
    private String nombreEtapa;
    @Column(name = "fecha_nda")
    private Date fechaNda;
    @Column(name = "f_acceso_herramienta")
    private Date fAccesoHerramienta;
    @Column(name = "f_creacion_formulario")
    private Date fCreacionFormulario;
    @Column(name = "f_envio_formulario")
    private Date fEnvioFormulario;
    @Column(name = "f_demostracion")
    private Date fDemostracion;
    @Column(name = "f_entrega_inf_evaluadores")
    private Date fEntregaInfEvaluadores;
    @Column(name = "f_entrega_informe")
    private Date fEntregaInforme;
    @Column(name = "f_entrega_evidencia_final")
    private Date fEntregaEvidenciaFinal;
    @Column(name = "f_entrega_evidencia_fonasa")
    private Date fEntregaEvidenciaFonasa;
    @Column(name = "f_integracion_fonasa")
    private Date fIntegracionFonasa;
    @Column(name = "f_otorgamiento")
    private Date fOtorgamiento;
    @ManyToOne
    private Empresa empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }

    public Date getFechaNda() {
        return fechaNda;
    }

    public void setFechaNda(Date fechaNda) {
        this.fechaNda = fechaNda;
    }

    public Date getfAccesoHerramienta() {
        return fAccesoHerramienta;
    }

    public void setfAccesoHerramienta(Date fAccesoHerramienta) {
        this.fAccesoHerramienta = fAccesoHerramienta;
    }

    public Date getfCreacionFormulario() {
        return fCreacionFormulario;
    }

    public void setfCreacionFormulario(Date fCreacionFormulario) {
        this.fCreacionFormulario = fCreacionFormulario;
    }

    public Date getfEnvioFormulario() {
        return fEnvioFormulario;
    }

    public void setfEnvioFormulario(Date fEnvioFormulario) {
        this.fEnvioFormulario = fEnvioFormulario;
    }

    public Date getfDemostracion() {
        return fDemostracion;
    }

    public void setfDemostracion(Date fDemostracion) {
        this.fDemostracion = fDemostracion;
    }

    public Date getfEntregaInfEvaluadores() {
        return fEntregaInfEvaluadores;
    }

    public void setfEntregaInfEvaluadores(Date fEntregaInfEvaluadores) {
        this.fEntregaInfEvaluadores = fEntregaInfEvaluadores;
    }

    public Date getfEntregaInforme() {
        return fEntregaInforme;
    }

    public void setfEntregaInforme(Date fEntregaInforme) {
        this.fEntregaInforme = fEntregaInforme;
    }

    public Date getfEntregaEvidenciaFinal() {
        return fEntregaEvidenciaFinal;
    }

    public void setfEntregaEvidenciaFinal(Date fEntregaEvidenciaFinal) {
        this.fEntregaEvidenciaFinal = fEntregaEvidenciaFinal;
    }

    public Date getfEntregaEvidenciaFonasa() {
        return fEntregaEvidenciaFonasa;
    }

    public void setfEntregaEvidenciaFonasa(Date fEntregaEvidenciaFonasa) {
        this.fEntregaEvidenciaFonasa = fEntregaEvidenciaFonasa;
    }

    public Date getfIntegracionFonasa() {
        return fIntegracionFonasa;
    }

    public void setfIntegracionFonasa(Date fIntegracionFonasa) {
        this.fIntegracionFonasa = fIntegracionFonasa;
    }

    public Date getfOtorgamiento() {
        return fOtorgamiento;
    }

    public void setfOtorgamiento(Date fOtorgamiento) {
        this.fOtorgamiento = fOtorgamiento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
