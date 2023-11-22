package com.example.nikita.service;

import com.example.nikita.dao.ProjectDAO;
import com.example.nikita.dto.PetDTO;
import com.example.nikita.dto.ProjectDTO;
import com.example.nikita.entity.Pet;
import com.example.nikita.entity.Project;
import com.example.nikita.exception_handling.NoSuchEmployeeException;
import com.example.nikita.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private ProjectMapper projectMapper;

    public void deleteEmployee(int id) {
        projectDAO.deleteById(id);
    }

    public ProjectDTO getProject(int id) {
        Optional<Project> optionalEmployee1 = projectDAO.findById(id);

        Project employee = optionalEmployee1.orElse(null);

        if (employee== null) {
            throw new NoSuchEmployeeException("There is no pet with id = " + id + " in database");
        }

        ProjectDTO employeeDTO = projectMapper.toProjectDTO(employee);

        if (employeeDTO == null) {
            throw new NoSuchEmployeeException("There is no employee with id = " + id + " in database");
        }

        Optional<ProjectDTO> optionalEmployee = Optional.ofNullable(employeeDTO);
        return optionalEmployee.orElse(null);
    }
}
