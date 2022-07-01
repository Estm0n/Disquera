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
import com.sena.spring.model.Cancion;
import com.sena.spring.service.IAlbumService;
import com.sena.spring.service.ICancionService;

@Controller //catalogar clase como un controlador
@SessionAttributes("cancion")
@RequestMapping("/cancion") 
public class CancionController {
    @Autowired
    private ICancionService felipe;

    @Autowired
    private IAlbumService andres;

    @GetMapping("/listar")
    public String listar(@Valid Cancion cancion, Model m){
        m.addAttribute("canc", felipe.findAll());
        return "cancion/listarCancion";
    }
 
    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model m){
        Cancion cancion=null;
        List<Album> album=andres.findAll();
        if (id>0) {
            cancion=felipe.findOne(id);
        }else{
            return "redirect:cancion/listarCancion";
        }
        m.addAttribute("cancion", cancion);
        m.addAttribute("album", album);
        m.addAttribute("accion", "Actualizar cancion");
        return "cancion/formulario";
    }

    @GetMapping("/formulario")
    public String form(Model m){
        Cancion cancion=new Cancion();
        List<Album> album=andres.findAll();
        m.addAttribute("cancion", cancion);
        m.addAttribute("album", album);
        m.addAttribute("accion", "Agregar cancion");
        return "cancion/formulario";
    }
    
    @PostMapping("/add")
    public String add(@Valid Cancion cancion, BindingResult res, Model m, SessionStatus status){
        felipe.save(cancion);
        status.setComplete();
        return "redirect:listar";
        }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        if(id > 0){
            felipe.delete(id);
        }
        return "redirect:../listar";
    }
    
}
