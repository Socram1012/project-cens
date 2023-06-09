package com.proyecto.cens.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sub_ambito")
public class Subambito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter@Column(name = "id")
    private Long id;
    @Getter@Setter@Column(name = "nombre")
    private String nombre;
    @Getter@Setter@Column(name = "comentario")
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "ambito_id")
    private Ambito ambito;

    public Subambito() { }
    public Subambito(String nombre, String comentario) {
        this.nombre = nombre;
        this.comentario = comentario;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;
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
    public String getComentario() { return  comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

}
