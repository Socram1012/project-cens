package com.proyecto.cens.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "empresa")
@ToString
@EqualsAndHashCode
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
    @OneToOne(mappedBy = "empresa")
    private Usuario usuario;

    public Empresa() { }
    public Empresa(String rut_empresa, String razon_social, Date fecha_ingreso) {
        this.rut_empresa = rut_empresa;
        this.razon_social = razon_social;
        this.fecha_ingreso = fecha_ingreso;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRutEmpresa() { return rut_empresa; }
    public void setRutEmpresa(String rut_empresa) { this.rut_empresa = rut_empresa; }
    public String getRazonSocial() { return razon_social; }
    public void setRazonSocial(String razon_social) { this.razon_social = razon_social; }
    public Date getFechaIngreso() { return fecha_ingreso; }
    public void setFechaIngreso(Date fecha_ingreso) { this.fecha_ingreso = fecha_ingreso; }

}
