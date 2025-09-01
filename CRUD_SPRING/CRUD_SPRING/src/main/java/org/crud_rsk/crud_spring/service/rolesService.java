package org.crud_rsk.crud_spring.service;


import org.crud_rsk.crud_spring.Repository.rolesRepository;
import org.crud_rsk.crud_spring.entity.roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class rolesService {

    @Autowired
    rolesRepository rolesRepository;

    public List<roles> getRoles(){
        return rolesRepository.findAll();
    }

    public Optional<roles> getRol(int id){
        return rolesRepository.findById(id);
    }

    public void saveRol(roles Rol){
        rolesRepository.save(Rol);
    }

    public void delete(int id){
        rolesRepository.deleteById(id);
    }

}
