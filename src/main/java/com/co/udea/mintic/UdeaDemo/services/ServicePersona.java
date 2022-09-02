package com.co.udea.mintic.UdeaDemo.services;

import com.co.udea.mintic.UdeaDemo.domain.Persona;
import com.co.udea.mintic.UdeaDemo.repository.EntityPersona;
import com.co.udea.mintic.UdeaDemo.repository.RepositoryPersona;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicePersona {

    @Getter
    @Setter
    private String nombrePrograma;

    @Autowired
    RepositoryPersona repositoryPersona;

    ArrayList <Persona> listaP;

    public ServicePersona(ArrayList<Persona> listaP) {
        this.listaP = listaP;
    }

    public String inscribirAlumno(Persona alumno){

       String inscripcion = "El alumno " + alumno.getNombre() + " " + alumno.getApellido() + " Con " + alumno.getEdad() + "  años, Quedo inscrito al programa "  ;

       return inscripcion;
    }


    public ArrayList doWhile(int a){
        ArrayList <String> objTraza = new ArrayList();
    do {
        System.out.println("Hola Mundo " + a);
        objTraza.add("Hola Mundo  " + String.valueOf(a));
        a++;
    }while(a<10);

    return objTraza;
    }

    public boolean addPersona(Persona persona){


        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());

        listaP.add(objPersona);

        return Boolean.TRUE;

    }

    public ArrayList<Persona> listar (){

        System.out.println("Metodo listar del service");

        return listaP;

    }

    public Persona buscarPersona (int id){

        Persona persona = null;

        for (Persona p :listaP ) {
            if (p.getId() == id){
                return p;
            }
        }

        return persona;
    }


    public boolean addPersonaCC(Persona persona, String doc){


        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());
        objPersona.setDoc(doc);

        System.out.println("Creo la persona con Cedula de ciudadania");

        listaP.add(objPersona);

        return Boolean.TRUE;

    }

    public boolean addPersonaTI(Persona persona, String doc){


        Persona objPersona = new Persona();
        objPersona.setNombre(persona.getNombre());
        objPersona.setApellido(persona.getApellido());
        objPersona.setEdad(persona.getEdad());
        objPersona.setId(persona.getId());
        objPersona.setDoc(doc);

        System.out.println("Creo la persona con Tarjeta de Identidad");

        listaP.add(objPersona);

        return Boolean.TRUE;

    }

    public Boolean borrarPersona(Persona persona){

        listaP.remove(persona);

        return Boolean.TRUE;

    }

    public List <EntityPersona>  listarTodosJPA (){

        List<EntityPersona> list = repositoryPersona.findAll();

        return  list;

    }

    public Boolean insertarPersonaJPA(EntityPersona persona){
        try {
            repositoryPersona.save(persona);
        }catch (Exception e){

            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }


    public Boolean actualizarTodoJPA (EntityPersona persona){

        try {
            repositoryPersona.save(persona);
        }catch (Exception e){

            return Boolean.FALSE;
        }
        return Boolean.TRUE;


    }


    public void actualizarParcialJPA (EntityPersona persona){

       EntityPersona perTemp =  repositoryPersona.findById(persona.getId()).orElse(null);

       if (persona.getNombre() != null){
           perTemp.setNombre(persona.getNombre());
       }else if (persona.getApellido() != null){
           perTemp.setApellido(persona.getApellido());
       }else if (persona.getEdad() != null){
           perTemp.setEdad(persona.getEdad());
       }else if (persona.getDoc() != null){
           perTemp.setDoc(persona.getDoc());
       }else if (persona.getPassword() != null){
           perTemp.setPassword(persona.getPassword());
       }

        repositoryPersona.save(perTemp);

    }

    public void deletePersonaById (Long id){

        repositoryPersona.deleteById(id);
    }



}
