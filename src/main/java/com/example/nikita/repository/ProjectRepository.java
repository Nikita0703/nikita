package com.example.nikita.repository;

import com.example.nikita.entity.Pet;
import com.example.nikita.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Pet,Integer> {
    Optional<Project> findById(int id);
    void deleteById(int id);
}
