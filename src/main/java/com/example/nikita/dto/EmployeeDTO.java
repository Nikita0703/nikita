package com.example.nikita.dto;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;

import java.util.List;

// Data Transfer Object
public class EmployeeDTO {
    private int id;
    private String name;
    private String surname;
    private int salary;
    private String department;

    @JsonView(View.Employee.class)
    private List<ProjectDTO> projects;



      public EmployeeDTO(int id, String name, String surname, int salary, String department, List<ProjectDTO> projects) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.projects = projects;
    }

    public EmployeeDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
