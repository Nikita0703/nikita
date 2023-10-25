package com.example.nikita.dao;

import com.example.nikita.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee,Integer> {
    Optional<Employee> findById(int id);
    void deleteById(int id);

}
