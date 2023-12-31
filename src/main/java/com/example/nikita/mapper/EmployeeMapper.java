package com.example.nikita.mapper;

import com.example.nikita.dto.*;
import com.example.nikita.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapper {
    public Employee toEmployee(EmployeeDTO employeedto){
        Car car = Car.builder().
                model(employeedto.getCar().getModel())
                .made(employeedto.getCar().getMade()).
                build();

        House house = House.builder()
                .adress(employeedto.getHouse().getAdress())
                .flour(employeedto.getHouse().getFlour())
                .flat(employeedto.getHouse().getFlat())
                .build();

        List<Pet> pets = new ArrayList<>();

        for (PetDTO petDTO:employeedto.getPets()){
            Pet pet = Pet.builder().
                    id(petDTO.getId()).
                    vid(petDTO.getVid())
                    .petname(petDTO.getName()).
                    build();
            pets.add(pet);
        }

        List<Project> projects = new ArrayList<>();

        for (ProjectDTO projectDTO:employeedto.getProjects()){
            Project project = Project.builder().
                    id(projectDTO.getId()).
                    title(projectDTO.getTitle())
                    .year(projectDTO.getYear()).
                    build();
            projects.add(project);
        }

        Employee employee = Employee.builder().
                id(employeedto.getId()).
                username(employeedto.getUsername()).
                password(employeedto.getPassword()).
                email(employeedto.getEmail()).
                name(employeedto.getName())
                .surname(employeedto.getSurname())
                .salary(employeedto.getSalary())
                .department(employeedto.getDepartment())
                .car(car)
                .house(house)
                .pets(pets)
                .projects(projects)
                .roles(employeedto.getRoles())
                .authorities(employeedto.getAuthorities())
                .build();

        return employee;

    }

    public EmployeeDTO toEmployeeDTO(Employee employee){
        CarDTO car = CarDTO.builder().
                model(employee.getCar().getModel())
                .made(employee.getCar().getMade()).
                build();

        HouseDTO house = HouseDTO.builder()
                .adress(employee.getHouse().getAdress())
                .flour(employee.getHouse().getFlour())
                .flat(employee.getHouse().getFlat())
                .build();

        List<PetDTO> pets = new ArrayList<>();

        for (Pet peto:employee.getPets()){
            PetDTO pet = PetDTO.builder().
                    id(peto.getId()).
                    vid(peto.getVid())
                    .petname(peto.getName()).
                    build();
            pets.add(pet);
        }

        List<ProjectDTO> projects = new ArrayList<>();

        for (Project project:employee.getProjects()){
            ProjectDTO projectDTO = ProjectDTO.builder().
                   id(project.getId()).
                    title(project.getTitle())
                    .year(project.getYear()).
                    build();
            projects.add(projectDTO);
        }

        EmployeeDTO employeeDTO = EmployeeDTO.builder().
                id(employee.getId()).
                username(employee.getUsername()).
                password(employee.getPassword()).
                email(employee.getEmail()).
                name(employee.getName())
                .surname(employee.getSurname())
                .salary(employee.getSalary())
                .department(employee.getDepartment())
                .car(car)
                .house(house)
                .pets(pets)
                .projects(projects)
                .roles(employee.getRoles())
                .authorities(employee.getAuthorities())
                .build();

        return employeeDTO;
    }

}
