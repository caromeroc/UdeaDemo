package com.co.udea.mintic.UdeaDemo.controller;


import com.co.udea.mintic.UdeaDemo.domain.Persona;
import com.co.udea.mintic.UdeaDemo.services.ServiceProgramaAcademico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;


@RestController
@RequestMapping (value = "/persona")
public class ControllerProgramaAcademico {


    @Autowired
    ServiceProgramaAcademico serviceProgramaAcademico;

    // este metodo sirve
   @GetMapping (path = "/udea/mintic/program", produces = "application/json")
   public ResponseEntity <String> callServicePrograma(){

       Persona alumno = new Persona();
       alumno.setNombre("Carlos1");
       alumno.setApellido("Romero22");
       alumno.setEdad(34);

       String salida = serviceProgramaAcademico.inscribirAlumno(alumno);

       return new ResponseEntity<String>(salida, HttpStatus.NOT_FOUND);

    }


    @GetMapping (path = "/udea/mintic/doWhile", produces = "application/json")
    public ArrayList doWhileController(){

        ArrayList<String> salida = new ArrayList<>();

        salida = serviceProgramaAcademico.doWhile(7);

        return salida;

    }

    @GetMapping (path = "/udea/mintic/listaPersonas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Persona> listaPersonas (){
        return serviceProgramaAcademico.listar();
   }

    @PostMapping (path = "/udea/mintic/crearPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity <Persona> crearPersona (@RequestBody Persona persona){

       boolean salida = serviceProgramaAcademico.addPersona(persona);


       if(salida == true){

           return new ResponseEntity<Persona>(persona, HttpStatus.OK);

       }else {

           return new ResponseEntity("Error de Ejecuión ", HttpStatus.INTERNAL_SERVER_ERROR);
       }



    }


    @GetMapping (path = "/udea/mintic/buscarPersona/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> buscarPersona (@PathVariable int id){
        Persona p = serviceProgramaAcademico.buscarPersona(id);
        if ( p != null){
            return new ResponseEntity<Persona>(p, HttpStatus.OK);
        }else{
            return new ResponseEntity("Error de Ejecución ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping (path = "/udea/mintic/crearPersona/{doc}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity <Persona> crearPersonaCondicional (@RequestBody Persona persona, @PathVariable String doc){

       //TODO --> Busar persona


       switch (doc){
           case "CC":
              serviceProgramaAcademico.addPersonaCC(persona, doc);
               break;
           case "TI":
               serviceProgramaAcademico.addPersonaTI(persona, doc);
               break;
           default:
               return new ResponseEntity("Error de Ejecución ", HttpStatus.INTERNAL_SERVER_ERROR);

       }
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

}
