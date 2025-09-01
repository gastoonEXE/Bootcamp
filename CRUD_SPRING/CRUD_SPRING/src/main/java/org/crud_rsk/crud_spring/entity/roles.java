package org.crud_rsk.crud_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // serial4 en PostgreSQL
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    // Constructor vacío (requerido por JPA)
    public roles() {}

    // Constructor con parámetros para comodidad
    public roles(String nombre) {
        this.nombre = nombre;
    }
}
