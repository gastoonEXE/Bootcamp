package org.crud_rsk.crud_spring.Repository;


import org.crud_rsk.crud_spring.entity.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface usuariosRepository extends JpaRepository<usuarios, Integer> {
    Optional<usuarios> findByNroCedula(Integer nroCedula);
}

