package com.example.nikita.service;

import com.example.nikita.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //List<Employee> getAllEmployees();
    public List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
