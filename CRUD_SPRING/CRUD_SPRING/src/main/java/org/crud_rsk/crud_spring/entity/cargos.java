package org.crud_rsk.crud_spring.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cargos")

public class cargos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Coincide con serial4 en PostgreSQL
    @Column(name = "id_cargo")
    private Integer idCargo;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    // Constructor vacío
    public cargos() {}

    // Constructor con parámetros
    public cargos(String nombre) {
        this.nombre = nombre;
    }
}