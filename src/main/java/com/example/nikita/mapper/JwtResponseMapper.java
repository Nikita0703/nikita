package com.example.nikita.mapper;

import com.example.nikita.dto.CarDTO;
import com.example.nikita.entity.Car;
import com.example.nikita.entity.Employee;
import com.example.nikita.payload.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtResponseMapper {
    @Autowired
    CarMapper carMapper;

    @Autowired
    HouseMapper houseMapper;

    @Autowired
    PetMapper petMapper;

    @Autowired
    ProjectMapper projectMapper;
    public JwtResponse toJwtResponse(String jwt, Employee userDetails, List<String> roles){
        JwtResponse response = JwtResponse.builder().
                token(jwt)
                .id(userDetails.getId()).
                username(userDetails.getUsername()).
                password(userDetails.getPassword()).
                name(userDetails.getName()).
                surname(userDetails.getSurname()).
                salary( userDetails.getSalary()).
                department(userDetails.getDepartment()).
                car(carMapper.toCarDTO(userDetails.getCar())).
                house(houseMapper.toHouseDTO(userDetails.getHouse())).
                pets(petMapper.toPetDTOList(userDetails.getPets())).
                projects(projectMapper.toProjectDTOList(userDetails.getProjects())).
                roles(roles).
                build();
        return response;
    }
}
