package com.example.nikita.payload.request;

import com.example.nikita.dto.*;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.List;
@Data
public class ChangeQualityRequest {

    private  int id;

    private String email;


    private String name;


    private String surname;


    private int salary;


    private String department;


    private CarDTO car;


    private HouseDTO house;


    private List<PetDTO> pets;


    private List<ProjectDTO> projects;

    public ChangeQualityRequest(int id,String email, String name, String surname, int salary, String department, CarDTO car, HouseDTO house, List<PetDTO> pets, List<ProjectDTO> projects) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
        this.car = car;
        this.house = house;
        this.pets = pets;
        this.projects = projects;
    }
}
