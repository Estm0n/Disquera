package com.sena.spring.service;
import java.util.List;

import com.sena.spring.model.Album;

public interface IAlbumService {
    
    public List<Album> findAll();
    public void save (Album album);
    public Album findOne(Integer id);
    public void delete(Integer id);
}
