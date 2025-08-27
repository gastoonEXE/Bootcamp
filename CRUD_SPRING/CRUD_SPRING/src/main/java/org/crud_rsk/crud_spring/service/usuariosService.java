package org.crud_rsk.crud_spring.service;


import org.crud_rsk.crud_spring.Repository.usuariosRepository;
import org.crud_rsk.crud_spring.entity.usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usuariosService {

    @Autowired
    usuariosRepository usuariosRepository;

    public List<usuarios> getUsuarios(){
        return usuariosRepository.findAll();
    }

    public Optional<usuarios> getUsuarios(Integer id){
        return usuariosRepository.findById(id);
    }

    public void saveOrUpdate(usuarios usuarios){
        usuariosRepository.save(usuarios);
    }

    public void delete(Integer id){
        usuariosRepository.deleteById(id);
    }
}
