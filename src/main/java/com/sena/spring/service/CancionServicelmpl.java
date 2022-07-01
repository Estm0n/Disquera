package com.sena.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.spring.model.Cancion;
import com.sena.spring.model.ICancion;

@Service
public class CancionServicelmpl implements ICancionService{

    @Autowired
    private ICancion lopez;
    
    @Override
    public List<Cancion> findAll() {
        return (List<Cancion>) lopez.findAll();
    }

    @Override
    public void save(Cancion cancion) {
        lopez.save(cancion);
    }

    @Override
    public Cancion findOne(Integer id) {
        return lopez.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        lopez.deleteById(id);
        
    }
    
}

