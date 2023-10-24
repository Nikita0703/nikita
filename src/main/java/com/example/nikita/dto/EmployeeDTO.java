package com.example.nikita.dto;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

// Data Transfer Object
@Builder
//@Allargsconstructor
public class EmployeeDTO {
    @JsonView(View.Employee.class)
    private int id;
    @JsonView(View.Employee.class)
    private String name;
    @JsonView(View.Employee.class)
    private String surname;
    @JsonView(View.Employee.class)
    private int salary;
    @JsonView(View.Employee.class)
    private String department;
    @JsonView(View.Employee.class)
    private CarDTO car;
    @JsonView(View.Employee.class)
    private HouseDTO house;
    @JsonView(View.Employee.class)
    private List<PetDTO> pets;
    @JsonView(View.Employee.class)
    private List<ProjectDTO> projects;



      public EmployeeDTO( String name, String surname, int salary, String department, List<ProjectDTO> projects) {
        //this.id=id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.projects = projects;
    }

    public EmployeeDTO(int id, String name, String surname, int salary, String department, CarDTO car, HouseDTO house, List<PetDTO> pets, List<ProjectDTO> projects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.car = car;
        this.house = house;
        this.pets = pets;
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

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public HouseDTO getHouse() {
        return house;
    }

    public void setHouse(HouseDTO house) {
        this.house = house;
    }

    public List<PetDTO> getPets() {
        return pets;
    }

    public void setPets(List<PetDTO> pets) {
        this.pets = pets;
    }
}
