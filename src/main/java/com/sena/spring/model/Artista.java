package com.sena.spring.model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="artista")
public class Artista {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private Integer no_documento;

    @Column(length = 50)
    private String tipo_documento;

    @Column(length = 10)
    private String nombre_artista;

    @Column(length=10)
    private String apellido_artista;

    @Column(length = 10)
    private String nombre_artistico;

    @Column
    private Date fecha_nacimiento;

    @Column(length = 10)
    private String email_artista;

    @Column
    private Boolean estado_artista;

    @ManyToOne(fetch = FetchType.LAZY)
    private Disquera disquera;


    //consturctores

    public Artista(){

    }


    public Artista(Integer id, Integer no_documento, String tipo_documento, String nombre_artista,
            String apellido_artista, String nombre_artistico, Date fecha_nacimiento, String email_artista,
            Boolean estado_artista) {
        this.id = id;
        this.no_documento = no_documento;
        this.tipo_documento = tipo_documento;
        this.nombre_artista = nombre_artista;
        this.apellido_artista = apellido_artista;
        this.nombre_artistico = nombre_artistico;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email_artista = email_artista;
        this.estado_artista = estado_artista;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getNo_documento() {
        return no_documento;
    }


    public void setNo_documento(Integer no_documento) {
        this.no_documento = no_documento;
    }


    public String getTipo_documento() {
        return tipo_documento;
    }


    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }


    public String getNombre_artista() {
        return nombre_artista;
    }


    public void setNombre_artista(String nombre_artista) {
        this.nombre_artista = nombre_artista;
    }


    public String getApellido_artista() {
        return apellido_artista;
    }


    public void setApellido_artista(String apellido_artista) {
        this.apellido_artista = apellido_artista;
    }


    public String getNombre_artistico() {
        return nombre_artistico;
    }


    public void setNombre_artistico(String nombre_artistico) {
        this.nombre_artistico = nombre_artistico;
    }


    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }


    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }


    public String getEmail_artista() {
        return email_artista;
    }


    public void setEmail_artista(String email_artista) {
        this.email_artista = email_artista;
    }


    public Boolean getEstado_artista() {
        return estado_artista;
    }


    public void setEstado_artista(Boolean estado_artista) {
        this.estado_artista = estado_artista;
    }

    
}