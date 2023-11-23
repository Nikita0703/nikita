package com.example.nikita.dao;

import com.example.nikita.entity.ERole;
import com.example.nikita.entity.Pet;
import com.example.nikita.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDAO extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
}
