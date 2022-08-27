package com.co.udea.mintic.UdeaDemo.controller;

import com.co.udea.mintic.UdeaDemo.services.ServicePersona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerDemoLegacy {

    ServicePersona services;

    public ControllerDemoLegacy(ServicePersona services) {
        this.services = services;
    }

    @ResponseBody
    @RequestMapping(value = "/udea/path2")
    public String mensaje(){
        return "Hola Mundo";
    }

}
