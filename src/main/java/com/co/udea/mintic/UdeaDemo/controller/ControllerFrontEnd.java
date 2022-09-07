package com.co.udea.mintic.UdeaDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerFrontEnd {

    @GetMapping (path = "/")
    public String home(){

        return "index";
    }

    @GetMapping (path = "/pagina2")
    public String pagina2(){

        return "pagina2";
    }



}
