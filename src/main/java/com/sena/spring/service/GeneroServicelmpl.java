package com.sena.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.spring.model.Genero;
import com.sena.spring.model.IGenero;

@Service
public class GeneroServicelmpl implements IGeneroService{

    @Autowired
    private IGenero rodriguez;
    @Override
    public List<Genero> findAll() {
        return (List<Genero>) rodriguez.findAll();
    }

    @Override
    public void save(Genero genero) {
        rodriguez.save(genero);
    }

    @Override
    public Genero findOne(Integer id_genero) {
        return rodriguez.findById(id_genero).orElse(null);
    }

    @Override
    public void delete(Integer id_genero) {
        rodriguez.deleteById(id_genero);
        
    }
    
}
