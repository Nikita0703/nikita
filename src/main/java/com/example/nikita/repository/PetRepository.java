package com.example.nikita.repository;

import com.example.nikita.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet,Integer> {

    Optional<Pet> findById(int id);
    void deleteById(int id);
}
