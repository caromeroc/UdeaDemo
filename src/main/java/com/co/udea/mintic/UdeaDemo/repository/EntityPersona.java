package com.co.udea.mintic.UdeaDemo.repository;

import com.co.udea.mintic.UdeaDemo.util.EnumRol;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

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
    private Long edad;
    @Column (name = "doc")
    private String doc;
    @Column (name = "Password")
    private String password;
    @Column (name = "rol")
    @Enumerated (EnumType.STRING)
    private EnumRol rol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    @JsonIgnore
    private Collection<EntityPermisos> permisosCollection;

}
