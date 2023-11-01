package com.example.nikita.service;

import com.example.nikita.dto.*;
import com.example.nikita.entity.*;
import com.example.nikita.exception_handling.NoSuchEmployeeException;
import com.example.nikita.facade.EmployeeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.nikita.dao.EmployeeDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeFacade employeeFacade;

    @Override

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeDAO.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee:employees){

            EmployeeDTO employeeDTO = employeeFacade.EmployeeDTO(employee);
            employeeDTOS.add(employeeDTO);

        }
        return employeeDTOS;
    }

    @Override
    public Employee saveEmployee(EmployeeDTO employeedto) {
        Employee employee = employeeFacade.Employee(employeedto);
        return employeeDAO.save(employee);
    }

    @Override

    public EmployeeDTO getEmployee(int id) {
        Optional<Employee> optionalEmployee1 = employeeDAO.findById(id);

        Employee employee = optionalEmployee1.orElse(null);

        if (employee== null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");
        }

        EmployeeDTO employeeDTO = employeeFacade.EmployeeDTO(employee);

        if (employeeDTO == null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");
        }

        Optional<EmployeeDTO> optionalEmployee = Optional.ofNullable(employeeDTO);
        return optionalEmployee.orElse(null);
    }

    @Override

    public void deleteEmployee(int id) {
        employeeDAO.deleteById(id);
    }



}
