package org.crud_rsk.crud_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@Table(name = "usuarios")
public class usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(unique = true, name = "nro_cedula", nullable = false)
    private Integer nroCedula;

    @Column(unique = true, nullable = false)
    private String correo;

    @Column(name = "id_rol", nullable = false)
    private Integer idRol;

    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;


//    private Period antiguedad;
    @Column(name = "antiguedad")
    private String antiguedad;


    @Column(name = "dias_vacaciones")
    private Integer diasVacaciones = 0;

    private Boolean estado = true;

    @Column(nullable = false)
    private String contrasena = "default_password";

    private String telefono;

    @Column(name = "id_equipo")
    private Integer idEquipo;

    @Column(name = "id_cargo")
    private Integer idCargo;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "dias_vacaciones_restante")
    private Integer diasVacacionesRestante = 0;

    @Column(name = "requiere_cambio_contrasena")
    private Boolean requiereCambioContrasena;

    // Getters y Setters

    // Constructor vacío
    public usuarios() {}

}
