package com.example.nikita.controller;

import com.example.nikita.dto.EmployeeDTO;
import com.example.nikita.dto.ProjectDTO;
import com.example.nikita.dto.View;
import com.example.nikita.entity.Employee;
import com.example.nikita.entity.Project;
import com.example.nikita.exception_handling.NoSuchEmployeeException;
import com.example.nikita.service.EmployeeService;
import com.example.nikita.service.ProjectServiceimpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api1")
@CrossOrigin
public class MyRESTController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectServiceimpl projectService;

    @GetMapping("/employees")
    @JsonView(View.Employee.class)
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();

        return employees;
    }
    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        List<Project> employees = projectService.getAllProjects();
        return employees;
    }

    @GetMapping("/employees/{id}")
    @JsonView(View.Employee.class)
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");
        }
        return employee;
    }

    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable int id) {
        Project employee = projectService.getProject(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");
        }
        return employee;
    }


    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PostMapping("/projects")
    public Project saveProject(@RequestBody Project employee) {
        projectService.saveProject(employee);
        return employee;
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project employee) {
        projectService.saveProject(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
           throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }

    @DeleteMapping("/projects/{id}")
    public String deleteProject(@PathVariable int id) {
        Project employee = projectService.getProject(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }
}
