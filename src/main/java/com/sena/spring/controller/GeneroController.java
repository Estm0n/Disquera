package com.sena.spring.controller;
import com.sena.spring.model.Genero;
import com.sena.spring.service.IGeneroService;

//importe de librerias

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

@Controller //catalogar clase como un controlador
@SessionAttributes("genero")
@RequestMapping("/genero") 
public class GeneroController {
    
    @Autowired
    private IGeneroService cristian;

    @GetMapping(path = {"/listar","","/"})
    public String lista(Model m){
        m.addAttribute("gene", cristian.findAll());
        return "genero/listarGenero";
    }
 
    @GetMapping("/ver/{id_genero}")
    public String editar(@PathVariable Integer id_genero, Model m){
        Genero genero=null;
        if (id_genero>0) {
            genero=cristian.findOne(id_genero);
        }else{
            return "redirect:listar";
        }

        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Actualizar genero");
        return "genero/formulario";
    } 

    @GetMapping("/verc/{id_genero}")
    public String verc(@PathVariable Integer id_genero,Model m){
        Genero genero=null;
        if(id_genero>0){
            genero=cristian.findOne(id_genero);
        }else{
            return "redirect:listgenero";
        }
        m.addAttribute("genero", genero);
        return "genero/vercgenero";
    }
    

    @GetMapping("/formulario")
    public String form(Model m){
        Genero genero=new Genero();
        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Agregar genero");
        return "genero/formulario";
    }
    
    @PostMapping("/add")
    public String add(@Valid Genero genero, BindingResult res, Model m, SessionStatus status){
        if(res.hasErrors()){
            return "genero/formulario";
        }
        cristian.save(genero);
        status.setComplete();
        return "redirect:../genero/listar";
        }

    @GetMapping("/delete/{id_genero}")
    public String delete(@PathVariable Integer id_genero) {
        if(id_genero > 0){
            cristian.delete(id_genero);
        }
        return "redirect:../listar";
    }
    
}
        