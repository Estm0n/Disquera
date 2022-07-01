package com.sena.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table (name="genero")
public class Genero {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_genero;

    @Size(min=2,max=50)
    @Column(name="nombreGenero", length = 50)
    private String nombre_genero;
    
    @Column(nullable = false)
    private Boolean estado_genero;

    @OneToMany(mappedBy = "genero",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Album> album;
    
    //Constructores
    public Genero() {
        album=new ArrayList<Album>();
    }

    public Genero(Integer id_genero, @Size(min = 2, max = 50) String nombre_genero, Boolean estado_genero,
            List<Album> album) {
        this.id_genero = id_genero;
        this.nombre_genero = nombre_genero;
        this.estado_genero = estado_genero;
        this.album = album;
    }

    public Integer getId_genero() {
        return id_genero;
    }

    public void setId_genero(Integer id_genero) {
        this.id_genero = id_genero;
    }

    public String getNombre_genero() {
        return nombre_genero;
    }

    public void setNombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }

    public Boolean getEstado_genero() {
        return estado_genero;
    }

    public void setEstado_genero(Boolean estado_genero) {
        this.estado_genero = estado_genero;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

}