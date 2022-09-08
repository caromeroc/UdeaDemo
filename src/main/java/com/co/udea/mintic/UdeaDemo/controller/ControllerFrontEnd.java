package com.co.udea.mintic.UdeaDemo.controller;

import com.co.udea.mintic.UdeaDemo.repository.EntityPersona;
import com.co.udea.mintic.UdeaDemo.services.ServicePersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControllerFrontEnd {

    @Autowired
    ServicePersona servicePersona;

    @GetMapping (path = "/")
    public String home(){

        return "index";
    }

    @GetMapping (path = "/pagina2")
    public String pagina2(Model modelo){

        List<EntityPersona> listPersonas = servicePersona.listarTodosJPA();
        modelo.addAttribute("personas", listPersonas);

        return "pagina2";
    }



}
