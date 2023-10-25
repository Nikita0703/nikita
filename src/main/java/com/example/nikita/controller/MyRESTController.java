package com.example.nikita.controller;

import com.example.nikita.dto.EmployeeDTO;
import com.example.nikita.dto.View;
import com.example.nikita.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1")
@CrossOrigin
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    @JsonView(View.Employee.class)
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return employees;
    }

    @GetMapping("/employees/{id}")
    @JsonView(View.Employee.class)
    public EmployeeDTO getEmployee(@PathVariable int id) {
        EmployeeDTO employee = employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping("/employees")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeedto) {
        employeeService.saveEmployee(employeedto);
        return employeedto;
    }

    @PutMapping("/employees")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return employeeDTO;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        EmployeeDTO employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }


}
