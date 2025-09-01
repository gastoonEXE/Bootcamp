package org.crud_rsk.crud_spring.Repository;

import org.crud_rsk.crud_spring.entity.equipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface equiposRepository extends JpaRepository<equipos, Integer> {
}
