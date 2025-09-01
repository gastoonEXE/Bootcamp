package org.crud_rsk.crud_spring.service;


import org.crud_rsk.crud_spring.Repository.cargosRepository;
import org.crud_rsk.crud_spring.entity.cargos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class cargosService {

    @Autowired
    cargosRepository cargosRepository;

    public List<cargos> getCargos(){
        return cargosRepository.findAll();
    }

    public Optional<cargos> getCargo(int id){
        return cargosRepository.findById(id);
    }

    public void saveCargo(cargos cargo){
        cargosRepository.save(cargo);
    }

    public void delete(int id){
        cargosRepository.deleteById(id);
    }

}
