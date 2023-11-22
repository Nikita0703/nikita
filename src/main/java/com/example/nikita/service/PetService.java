package com.example.nikita.service;

import com.example.nikita.dao.PetDAO;
import com.example.nikita.dto.EmployeeDTO;
import com.example.nikita.dto.PetDTO;
import com.example.nikita.entity.Employee;
import com.example.nikita.entity.Pet;
import com.example.nikita.exception_handling.NoSuchEmployeeException;
import com.example.nikita.mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetDAO petDAO;

    @Autowired
    private PetMapper petMapper;

    public void deleteEmployee(int id) {
        petDAO.deleteById(id);
    }

    public PetDTO getPet(int id) {
        Optional<Pet> optionalEmployee1 = petDAO.findById(id);

        Pet employee = optionalEmployee1.orElse(null);

        if (employee== null) {
            throw new NoSuchEmployeeException("There is no pet with id = " + id + " in database");
        }

        PetDTO employeeDTO = petMapper.toPetDTO(employee);

        if (employeeDTO == null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");
        }

        Optional<PetDTO> optionalEmployee = Optional.ofNullable(employeeDTO);
        return optionalEmployee.orElse(null);
    }
}
