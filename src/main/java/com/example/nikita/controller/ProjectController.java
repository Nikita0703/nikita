package com.example.nikita.controller;

import com.example.nikita.dto.PetDTO;
import com.example.nikita.dto.ProjectDTO;
import com.example.nikita.service.PetService;
import com.example.nikita.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api1")
//@CrossOrigin
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @DeleteMapping("/projects/{id}")
    public String deleteProject(@PathVariable int id) {
        ProjectDTO employee = projectService.getProject(id);
        projectService.deleteEmployee(id);
        return "Employee with id = " + id + " was deleted";
    }
}
