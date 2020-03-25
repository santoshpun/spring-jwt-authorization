package com.santosh.springjwtauthorization.repository;

import com.santosh.springjwtauthorization.model.Role;
import com.santosh.springjwtauthorization.model.RolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RolesEnum name);

}
