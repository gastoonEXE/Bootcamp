package org.crud_rsk.crud_spring.controller;

import org.crud_rsk.crud_spring.Repository.rolesRepository;
import org.crud_rsk.crud_spring.entity.roles;
import org.crud_rsk.crud_spring.service.rolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/roles")
public class rolesController {

    @Autowired
    private rolesService rolesService;

    @Autowired
    rolesRepository rolesRepo;

    @GetMapping
    public List<roles> getAll(){
        return rolesService.getRoles();
    }

    @GetMapping("/{id_rol}")
    public Optional<roles> getById(@PathVariable("id_rol") Integer id_rol){
        return rolesService.getRol(id_rol);
    }

    @PostMapping
    public ResponseEntity<String> saveUpdate(@RequestBody roles roles){

        // 1. Verificar que el rol con ese ID existe
        if(roles.getIdRol() != null){
            Optional<roles> existenteID = rolesRepo.findById(roles.getIdRol());
            if (existenteID.isPresent()) {
                System.out.println("el Rol con esa ID YA existe");
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body("Ya existe un Rol con esa ID: " + existenteID.get().getNombre());
            }
        }

        rolesService.saveRol(roles);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rol creado con éxito");

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody roles roles){
        rolesService.saveRol(roles);
    }

}
