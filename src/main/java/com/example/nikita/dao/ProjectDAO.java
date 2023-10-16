package com.example.nikita.dao;

import com.example.nikita.entity.Employee;
import com.example.nikita.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectDAO extends JpaRepository<Project,Integer> {
    Optional<Project> findById(int id);
    void deleteById(int id);
}
