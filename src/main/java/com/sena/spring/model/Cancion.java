package com.sena.spring.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="cancion")
public class Cancion {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nombre_cancion;

    @Column(length = 4)
    private String fech_grab;

    @Column(length=5)
    private String duracion_min;

    @Column
    private Boolean estado_cancion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    public Cancion(){
        
    }

    public Cancion(Integer id, String nombre_cancion, String fech_grab, String duracion_min, Boolean estado_cancion,
            Album album) {
        this.id = id;
        this.nombre_cancion = nombre_cancion;
        this.fech_grab = fech_grab;
        this.duracion_min = duracion_min;
        this.estado_cancion = estado_cancion;
        this.album = album;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getFech_grab() {
        return fech_grab;
    }

    public void setFech_grab(String fech_grab) {
        this.fech_grab = fech_grab;
    }

    public String getDuracion_min() {
        return duracion_min;
    }

    public void setDuracion_min(String duracion_min) {
        this.duracion_min = duracion_min;
    }

    public Boolean getEstado_cancion() {
        return estado_cancion;
    }

    public void setEstado_cancion(Boolean estado_cancion) {
        this.estado_cancion = estado_cancion;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

}
