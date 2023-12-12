package com.example.nikita.service;

import com.example.nikita.dto.EmployeeDTO;
import com.example.nikita.entity.Employee;
import com.example.nikita.payload.request.ChangePasswordRequest;
import com.example.nikita.payload.request.ChangeQualityRequest;

import java.util.List;

public interface EmployeeService {
    public List<EmployeeDTO> getAllEmployees();
    Employee saveEmployee(EmployeeDTO employeeDTO);

    Employee updateEmployee(ChangeQualityRequest employeeDTO);

    EmployeeDTO getEmployee(int id);

    void deleteEmployee(int id);

    boolean existsByPassword(String password);


    boolean existsByUsername(String username);

     void sendEmailMessage(String userEmail, String name);

     Employee saveWithNewPassword(ChangePasswordRequest changePasswordRequest);
}
