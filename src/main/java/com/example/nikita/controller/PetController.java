package com.example.nikita.controller;

import com.example.nikita.dto.EmployeeDTO;
import com.example.nikita.dto.PetDTO;
import com.example.nikita.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api1")
//@CrossOrigin
public class PetController {
    @Autowired
    private PetService petService;

    @DeleteMapping("/pets/{id}")
    public String deletePet(@PathVariable int id) {
        PetDTO employee = petService.getPet(id);
        petService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }
}
