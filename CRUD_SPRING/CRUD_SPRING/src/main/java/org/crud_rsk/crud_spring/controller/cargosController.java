package org.crud_rsk.crud_spring.controller;

import org.crud_rsk.crud_spring.Repository.cargosRepository;
import org.crud_rsk.crud_spring.Repository.usuariosRepository;
import org.crud_rsk.crud_spring.entity.cargos;
import org.crud_rsk.crud_spring.entity.usuarios;
import org.crud_rsk.crud_spring.service.cargosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/cargos")
public class cargosController {

    @Autowired
    private cargosService cargosService;

    @Autowired
    cargosRepository cargosRepo;

    @GetMapping
    public List<cargos> getAll(){
        return cargosService.getCargos();
    }

    @GetMapping("/{id_cargo}")
    public Optional<cargos> getById(@PathVariable("id_cargo") Integer id_cargo){
        return cargosService.getCargo(id_cargo);
    }

    @PostMapping
    public ResponseEntity<String> saveUpdate(@RequestBody cargos Cargos){

        // 1. Verificar que el cargo con ese ID existe
        if(Cargos.getIdCargo() != null){
            Optional<cargos> existenteID = cargosRepo.findById(Cargos.getIdCargo());
            if (existenteID.isPresent()) {
                System.out.println("el Cargo con esa ID YA existe");
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body("Ya existe un Cargo con esa ID: " + existenteID.get().getNombre());
            }
        }

        cargosService.saveCargo(Cargos);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cargo creado con éxito");

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody cargos cargos){
        cargosService.saveCargo(cargos);
    }

}
