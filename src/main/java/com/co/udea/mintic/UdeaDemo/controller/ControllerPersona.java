package com.co.udea.mintic.UdeaDemo.controller;

import com.co.udea.mintic.UdeaDemo.domain.Persona;
import com.co.udea.mintic.UdeaDemo.repository.EntityPersona;
import com.co.udea.mintic.UdeaDemo.services.ServicePersona;
import com.co.udea.mintic.UdeaDemo.util.EnumRol;
import com.co.udea.mintic.UdeaDemo.util.UtilidadesComunes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Api (tags = "Persona", description = "Metodos para el Api Persona")
@RestController
@CrossOrigin
@RequestMapping (value = "/persona")
public class ControllerPersona {


    @Autowired
    ServicePersona servicePersona;


    @Autowired
    UtilidadesComunes utilidadesComunes;


    @ApiOperation( value = "Endpoint para listar usuario")
   @GetMapping (path = "/udea/mintic/program", produces = "application/json")
   public ResponseEntity <String> callServicePrograma(){

       Persona alumno = new Persona();
       alumno.setNombre("Carlos1");
       alumno.setApellido("Romero22");
       alumno.setEdad(34);

       String salida = servicePersona.inscribirAlumno(alumno);

       return new ResponseEntity<String>(salida, HttpStatus.NOT_FOUND);

    }


    @GetMapping (path = "/udea/mintic/doWhile", produces = "application/json")
    public ArrayList doWhileController(){

        ArrayList<String> salida = new ArrayList<>();


        salida = servicePersona.doWhile(7);

        return salida;

    }

    @GetMapping (path = "/udea/mintic/listaPersonas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Persona> listaPersonas (){
        utilidadesComunes.mensaje();
        return servicePersona.listar();
   }

    @GetMapping (path = "/udea/mintic/buscarPersona/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> buscarPersona (@PathVariable int id){
        Persona p = servicePersona.buscarPersona(id);
        if ( p != null){
            return new ResponseEntity<Persona>(p, HttpStatus.OK);
        }else{
            return new ResponseEntity("Error de Ejecución ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping (path = "/udea/mintic/crearPersona", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity <Persona> crearPersona (@RequestBody Persona persona){

       boolean salida = servicePersona.addPersona(persona);


       if(salida == true){

           return new ResponseEntity<Persona>(persona, HttpStatus.OK);

       }else {

           return new ResponseEntity("Error de Ejecuión ", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }




    @PostMapping (path = "/udea/mintic/crearPersona/{doc}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity <Persona> crearPersonaCondicional (@RequestBody Persona persona, @PathVariable String doc){

       //TODO --> Buscar persona antes de insertar, validar si existe ya


       switch (doc){
           case "CC":
              servicePersona.addPersonaCC(persona, doc);
               break;
           case "TI":
               servicePersona.addPersonaTI(persona, doc);
               break;
           default:
               return new ResponseEntity("Error de Ejecución ", HttpStatus.INTERNAL_SERVER_ERROR);

       }
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

    @PutMapping ( path = "/udea/mintic/actualizarPersona", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Persona> actualizarPersona(@RequestParam int id, @RequestParam String nombreModificado){

        Persona p = servicePersona.buscarPersona(id);
        p.setNombre(nombreModificado);
    System.out.println("Metod PUT");

       return new ResponseEntity<Persona>(p, HttpStatus.OK);

    }

    @PatchMapping (path = "/udea/mintic/actualizarPP", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <String> actualizarPersonaParcial (){

       String retorno = "Actualizacion Parcial de dominio Persona";
       System.out.println("Ok, metodo patch");
       return new ResponseEntity<String >(retorno, HttpStatus.OK);

    }
    @DeleteMapping (path = "/udea/mintic/borrarPersona/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Boolean> borrarPersona (@PathVariable int id){

        Persona p = servicePersona.buscarPersona(id);

        Boolean salida = servicePersona.borrarPersona(p);

       return new ResponseEntity<Boolean>(salida, HttpStatus.OK);

    }

    @GetMapping (path = "/udea/mintic/listarTodosJPA", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Object> listarTodo (){

       return  new ResponseEntity<Object>(servicePersona.listarTodosJPA(), HttpStatus.OK);

    }

    @PostMapping (path = "/udea/mintic/insertarPersonaJPA", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <Boolean> insertarPersona (@RequestBody EntityPersona persona){

      return new ResponseEntity<Boolean>(servicePersona.insertarPersonaJPA(persona), HttpStatus.OK)  ;

    }

    @PutMapping (path = "/udea/mintic/actualizarTodoJPA")
    public RedirectView actualizarTodoJPA (@ModelAttribute EntityPersona persona, Model modelo){

        modelo.addAttribute(persona);
        if (servicePersona.actualizarTodoJPA(persona).equals(Boolean.TRUE)){
            return new RedirectView("/pagina2");
        }else{

            return new RedirectView("/error");
        }

    }

    @PatchMapping (path = "/udea/mintic/actualizarParcialJPA", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insertarParcialJPA (@RequestBody EntityPersona persona){

        servicePersona.actualizarParcialJPA(persona);
    }

    @DeleteMapping("/udea/mintic/borrarPersonaJPA/{id}")
    public RedirectView borrarPersonaJPA(@PathVariable("id") Long id) {
        servicePersona.deletePersonaById(id);
        return new RedirectView("/pagina2");
    }

    @PostMapping (path = "/udea/mintic/insertarPersonaRol")
    public RedirectView insertarPersonaRol (@ModelAttribute EntityPersona persona, Model modelo){
        modelo.addAttribute(persona);
        if (servicePersona.insertarPersonaRol (persona).equals(Boolean.TRUE)){
            return new RedirectView("/pagina2");
        }else{

            return new RedirectView("/error");
        }

    }



}
