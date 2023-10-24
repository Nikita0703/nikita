package com.example.nikita.service;

import com.example.nikita.dto.*;
import com.example.nikita.entity.*;
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

    @Override

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeDAO.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee:employees){
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
                        vid(peto.getVid())
                        .petname(peto.getName()).
                        build();
                pets.add(pet);
            }

            List<ProjectDTO> projects = new ArrayList<>();

            for (Project project:employee.getProjects()){
                ProjectDTO projectDTO = ProjectDTO.builder().
                        title(project.getTitle())
                        .year(project.getYear()).
                        build();
                projects.add(projectDTO);
            }

            EmployeeDTO employeeDTO = EmployeeDTO.builder().
                    id(employee.getId()).
                    name(employee.getName())
                    .surname(employee.getSurname())
                    .salary(employee.getSalary())
                    .department(employee.getDepartment())
                    .car(car)
                    .house(house)
                    .pets(pets)
                    .projects(projects)
                    .build();

            employeeDTOS.add(employeeDTO);

        }
        return employeeDTOS;
    }

    @Override
    public Employee saveEmployee(EmployeeDTO employeedto) {
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
                vid(petDTO.getVid())
                    .petname(petDTO.getName()).
                      build();
            pets.add(pet);
        }

        List<Project> projects = new ArrayList<>();

        for (ProjectDTO projectDTO:employeedto.getProjects()){
            Project project = Project.builder().
                    title(projectDTO.getTitle())
                    .year(projectDTO.getYear()).
                    build();
            projects.add(project);
        }

        Employee employee = Employee.builder().
                 id(employeedto.getId()).
                 name(employeedto.getName())
                .surname(employeedto.getSurname())
                .salary(employeedto.getSalary())
                .department(employeedto.getDepartment())
                .car(car)
                .house(house)
                .pets(pets)
                .projects(projects)
                .build();

        return employeeDAO.save(employee);
    }

    @Override

    public EmployeeDTO getEmployee(int id) {
        Optional<Employee> optionalEmployee1 = employeeDAO.findById(id);

        Employee employee = optionalEmployee1.orElse(null);

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
                    vid(peto.getVid())
                    .petname(peto.getName()).
                    build();
            pets.add(pet);
        }

        List<ProjectDTO> projects = new ArrayList<>();

        for (Project project:employee.getProjects()){
            ProjectDTO projectDTO = ProjectDTO.builder().
                    title(project.getTitle())
                    .year(project.getYear()).
                    build();
            projects.add(projectDTO);
        }

        EmployeeDTO employeeDTO = EmployeeDTO.builder().
                id(employee.getId()).
                name(employee.getName())
                .surname(employee.getSurname())
                .salary(employee.getSalary())
                .department(employee.getDepartment())
                .car(car)
                .house(house)
                .pets(pets)
                .projects(projects)
                .build();

        Optional<EmployeeDTO> optionalEmployee = Optional.ofNullable(employeeDTO);
        return optionalEmployee.orElse(null);
    }

    @Override

    public void deleteEmployee(int id) {
        employeeDAO.deleteById(id);
    }

   /// @Override
  //  public void update(int id){
        //Employee employee=employeeDAO.findById(id).get();
   // }

}
