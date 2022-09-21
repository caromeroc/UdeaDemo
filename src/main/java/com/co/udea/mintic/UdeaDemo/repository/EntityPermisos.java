package com.co.udea.mintic.UdeaDemo.repository;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "permisos")
public class EntityPermisos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "lectura")
    private Boolean lectura;
    @Column (name = "escritura")
    private Boolean escritura;
    @Column (name = "actualizar")
    private Boolean actualizar;
    @Column (name = "borrar")
    private Boolean borrar;
    @JoinColumn (name = "id_persona", referencedColumnName = "id")
    @ManyToOne (optional = false)
    private EntityPersona idPersona;

    public EntityPermisos() {
    }

    public EntityPermisos(Boolean lectura, Boolean escritura, Boolean actualizar, Boolean borrar, EntityPersona idPersona) {
        this.lectura = lectura;
        this.escritura = escritura;
        this.actualizar = actualizar;
        this.borrar = borrar;
        this.idPersona = idPersona;
    }
}
