package org.crud_rsk.crud_spring.controller;


import org.crud_rsk.crud_spring.Repository.usuariosRepository;
import org.crud_rsk.crud_spring.entity.usuarios;
import org.crud_rsk.crud_spring.service.usuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/usuarios")

public class usuariosController {


    @Autowired
    private usuariosService usuariosService;

    @GetMapping
    public List<usuarios> getAll(){
        return usuariosService.getUsuarios();
    }

    @GetMapping("/{id_usuario}")
    public Optional<usuarios> getById(@PathVariable("id_usuario") Integer ID){
        return usuariosService.getUsuarios(ID);
    }

    @PostMapping
    public void saveUpdate(@RequestBody usuarios User){
        if (User.getFechaIngreso() != null) {
            Period period = Period.between(User.getFechaIngreso(), LocalDate.now());
            String antiguedad = String.format("%d años, %d meses, %d días",
                    period.getYears(), period.getMonths(), period.getDays());
            User.setAntiguedad(antiguedad);
        }
        usuariosService.saveOrUpdate(User);
    }

    @DeleteMapping("/{id_usuario}")
    public void saveUpdate(@PathVariable("id_usuario") Integer ID){
        usuariosService.delete(ID);
    }



}
