package com.thl.ToDo.Repository;

import java.util.Optional;

import com.thl.ToDo.Entity.Role;
import com.thl.ToDo.Enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
