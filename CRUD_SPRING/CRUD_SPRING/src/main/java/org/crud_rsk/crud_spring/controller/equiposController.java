
package org.crud_rsk.crud_spring.controller;

import org.crud_rsk.crud_spring.Repository.equiposRepository;
import org.crud_rsk.crud_spring.Repository.usuariosRepository;
import org.crud_rsk.crud_spring.entity.equipos;
import org.crud_rsk.crud_spring.entity.usuarios;
import org.crud_rsk.crud_spring.service.equiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/equipos")
public class equiposController {

    @Autowired
    private equiposService equiposService;

    @Autowired
    equiposRepository equiposRepo;

    @GetMapping
    public List<equipos> getAll(){
        return equiposService.getEquipos();
    }

    @GetMapping("/{id_equipo}")
    public Optional<equipos> getById(@PathVariable("id_equipo") Integer id_equipo){
        return equiposService.getEquipo(id_equipo);
    }

    @PostMapping
    public ResponseEntity<String> saveUpdate(@RequestBody equipos equipos){

        // 1. Verificar que el equipo con ese ID existe
        if(equipos.getIdEquipo() != null){
            Optional<equipos> existenteID = equiposRepo.findById(equipos.getIdEquipo());
            if (existenteID.isPresent()) {
                System.out.println("el Equipo con esa ID YA existe");
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body("Ya existe un Equipo con esa ID: " + existenteID.get().getNombre());
            }
        }

        equiposService.saveEquipo(equipos);
        return ResponseEntity.status(HttpStatus.CREATED).body("Equipo creado con éxito");

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody equipos equipos){
        equiposService.saveEquipo(equipos);
    }

}
