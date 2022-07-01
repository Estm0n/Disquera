package com.sena.spring.service;
import java.util.List;

import com.sena.spring.model.Genero;

public interface IGeneroService {
    public List<Genero> findAll();
    public void save (Genero genero);
    public Genero findOne(Integer id_genero);
    public void delete(Integer id_genero);
}
