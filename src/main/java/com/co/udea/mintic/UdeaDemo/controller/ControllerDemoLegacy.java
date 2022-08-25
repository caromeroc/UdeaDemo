package com.co.udea.mintic.UdeaDemo.controller;

import com.co.udea.mintic.UdeaDemo.services.ServiceProgramaAcademico;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerDemoLegacy {

    ServiceProgramaAcademico services;

    public ControllerDemoLegacy(ServiceProgramaAcademico services) {
        this.services = services;
    }

    @ResponseBody
    @RequestMapping(value = "/udea/path2")
    public String mensaje(){
        return "Hola Mundo";
    }

}
