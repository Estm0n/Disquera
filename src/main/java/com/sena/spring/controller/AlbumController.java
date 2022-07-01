package com.sena.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sena.spring.model.Album;
import com.sena.spring.model.Genero;
import com.sena.spring.service.IAlbumService;
import com.sena.spring.service.IGeneroService;

@Controller
@SessionAttributes("album")
@RequestMapping ("/album")
public class AlbumController {

    @Autowired
    private IAlbumService rodriguez;

    @Autowired
    private IGeneroService lopez;

    @GetMapping("/listar")
    public String listar(@Valid Album album,Model m){
        m.addAttribute("album", rodriguez.findAll());
        return "album/listarAlbum";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model m){
        Album album=null;
        List<Genero> genero=lopez.findAll();
        if (id>0) {
            album=rodriguez.findOne(id);
        }else{
            return "redirect:album/listarAlbum";
        }
        m.addAttribute("album", album);
        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Editar Album");
        return "album/formulario";
    }

    @GetMapping("/verc/{id}")
    public String verc(@PathVariable Integer id,Model m){
        Album album=null;
        if(id>0){
            album=rodriguez.findOne(id);
        }else{
            return "redirect:listalbum";
        }
        m.addAttribute("album", album);
        return "album/vercalbum";
    }

    @GetMapping("/form")
    public String form(Model m){
        Album album=new Album();
        List<Genero> genero=lopez.findAll();
        m.addAttribute("album", album);
        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Agregar Album");
        return "album/formulario";
    }

    @PostMapping("/add")
    public String add(@Valid Album album,BindingResult res,Model Album, SessionStatus status){
        rodriguez.save(album);
        status.setComplete();
        return "redirect:listar";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(id>0) {
            rodriguez.delete(id);
        }
        return "redirect:../listar";
    }
}
