package org.crud_rsk.crud_spring.service;


import org.crud_rsk.crud_spring.Repository.equiposRepository;
import org.crud_rsk.crud_spring.entity.equipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class equiposService {

    @Autowired
    equiposRepository equiposRepository;

    public List<equipos> getEquipos(){
        return equiposRepository.findAll();
    }

    public Optional<equipos> getEquipo(int id){
        return equiposRepository.findById(id);
    }

    public void saveEquipo(equipos equipo){
        equiposRepository.save(equipo);
    }

    public void delete(int id){
        equiposRepository.deleteById(id);
    }

}
