package com.example.nikita.dao;

import com.example.nikita.entity.Employee;
import com.example.nikita.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetDAO extends JpaRepository<Pet,Integer> {

    Optional<Pet> findById(int id);
    void deleteById(int id);
}
