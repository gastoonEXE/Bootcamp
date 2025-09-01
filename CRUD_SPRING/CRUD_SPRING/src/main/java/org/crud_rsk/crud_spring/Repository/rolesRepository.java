package org.crud_rsk.crud_spring.Repository;

import org.crud_rsk.crud_spring.entity.roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface rolesRepository extends JpaRepository<roles, Integer> {
}
