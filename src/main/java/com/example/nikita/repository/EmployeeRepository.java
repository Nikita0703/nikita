package com.example.nikita.repository;

import com.example.nikita.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findById(int id);
    void deleteById(int id);

    Optional<Employee> findEmployeeByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByPassword(String password);
}
