package com.sena.spring.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="disquera")
public class Disquera {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private Integer nit_disquera;

    @Column(length = 50)
    private String nombre_disquera;

    @Column(length = 10)
    private String telefono_disquera;

    @Column(length=10)
    private String direccion_disquera;

    @Column
    private Boolean estado_cancion;


    //consturctores

    public Disquera(){

    }

    public Disquera(Integer id, Integer nit_disquera, String nombre_disquera, String telefono_disquera, String direccion_disquera, Boolean estado_cancion) {
        this.id = id;
        this.nit_disquera = nit_disquera;
        this.nombre_disquera = nombre_disquera;
        this.telefono_disquera = telefono_disquera;
        this.direccion_disquera = direccion_disquera;
        this.estado_cancion = estado_cancion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNit_disquera() {
        return nit_disquera;
    }

    public void setNit_disquera(Integer nit_disquera) {
        this.nit_disquera = nit_disquera;
    }

    public String getNombre_disquera() {
        return nombre_disquera;
    }

    public void setNombre_disquera(String nombre_disquera) {
        this.nombre_disquera = nombre_disquera;
    }

    public String getTelefono_disquera() {
        return telefono_disquera;
    }

    public void setTelefono_disquera(String telefono_disquera) {
        this.telefono_disquera = telefono_disquera;
    }

    public String getDireccion_disquera() {
        return direccion_disquera;
    }

    public void setDireccion_disquera(String direccion_disquera) {
        this.direccion_disquera = direccion_disquera;
    }

    public Boolean getEstado_cancion() {
        return estado_cancion;
    }

    public void setEstado_cancion(Boolean estado_cancion) {
        this.estado_cancion = estado_cancion;
    }

    
}