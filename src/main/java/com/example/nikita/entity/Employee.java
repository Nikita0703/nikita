package com.example.nikita.entity;

import com.example.nikita.dto.View;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee_full")
@Builder
@AllArgsConstructor

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(View.Employee.class)
    private int id;
    @JsonView(View.Employee.class)
    @Column(name = "name")
    private String name;

    @JsonView(View.Employee.class)
    @Column(name = "surname")
    private String surname;

    @JsonView(View.Employee.class)
    @Column(name = "department")
    private String department;

    @JsonView(View.Employee.class)
    @Column(name = "salary")
    private int salary;

    @JsonView(View.Employee.class)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;

    @JsonView(View.Employee.class)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id")
    private House house;

    @JsonView(View.Employee.class)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Pet> pets= new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "emps_projects",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )

    @JsonView(View.Employee.class)
    private List<Project> projects = new ArrayList<>();

    public Employee() {
    }

    public Employee(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String name, String surname, int salary, String department, Car car, House house, List<Pet> pets, List<Project> projects) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.car = car;
        this.house = house;
        this.pets = pets;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
