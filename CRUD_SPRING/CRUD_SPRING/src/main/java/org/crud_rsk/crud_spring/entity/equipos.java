package org.crud_rsk.crud_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "equipos")

public class equipos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // equivale a serial4 en PostgreSQL
    @Column(name = "id_equipo")
    private Integer idEquipo;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    // Constructor vacío (necesario para JPA)
    public equipos() {}

    // Constructor con parámetros para comodidad
    public equipos(String nombre) {
        this.nombre = nombre;
    }

}
