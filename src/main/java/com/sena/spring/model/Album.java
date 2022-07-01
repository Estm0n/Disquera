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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="album")
public class Album {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nombre_album;

    @Column(length = 4)
    private Integer anio_publicacion;

    @Column
    private Boolean estado_album;

    @OneToMany(mappedBy = "album",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cancion> cancion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genero genero;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artista artista;

    //constructores 
    public Album(){
        cancion=new ArrayList<Cancion>();
    }

	public Album(Integer id, String nombre_album, Integer anio_publicacion, Boolean estado_album, List<Cancion> cancion, Genero genero, Artista artista) {
		this.id = id;
		this.nombre_album = nombre_album;
		this.anio_publicacion = anio_publicacion;
		this.estado_album = estado_album;
		this.cancion = cancion;
		this.genero = genero;
		this.artista = artista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre_album() {
		return nombre_album;
	}

	public void setNombre_album(String nombre_album) {
		this.nombre_album = nombre_album;
	}

	public Integer getAnio_publicacion() {
		return anio_publicacion;
	}

	public void setAnio_publicacion(Integer anio_publicacion) {
		this.anio_publicacion = anio_publicacion;
	}

	public Boolean getEstado_album() {
		return estado_album;
	}

	public void setEstado_album(Boolean estado_album) {
		this.estado_album = estado_album;
	}

	public List<Cancion> getCancion() {
		return cancion;
	}

	public void setCancion(List<Cancion> cancion) {
		this.cancion = cancion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

    
}