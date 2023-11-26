package com.example.nikita.payload.response;
import com.example.nikita.dto.*;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private int id;

    private String name;

    private String surname;


    private int salary;


    private String department;


    private CarDTO car;


    private HouseDTO house;


    private List<PetDTO> pets;


    private List<ProjectDTO> projects;


    private List<String> roles;


    public JwtResponse(String accessToken,int id, String name, String surname, int salary, String department, CarDTO car, HouseDTO house, List<PetDTO> pets, List<ProjectDTO> projects, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.car = car;
        this.house = house;
        this.pets = pets;
        this.projects = projects;
        this.roles = roles;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<String> getRoles() {
        return roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}

