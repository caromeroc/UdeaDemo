package com.co.udea.mintic.UdeaDemo.repository;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "persona")
public class EntityPersona {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "apellido")
    private String apellido;
    @Column (name = "edad")
    private int edad;
    @Column (name = "doc")
    private String doc;

}
