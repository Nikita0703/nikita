package com.example.nikita.service;

import com.example.nikita.dto.EmployeeDTO;
import com.example.nikita.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //List<Employee> getAllEmployees();
    public List<EmployeeDTO> getAllEmployees();
    Employee saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployee(int id);

    void deleteEmployee(int id);
}
