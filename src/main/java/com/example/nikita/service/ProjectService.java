package com.example.nikita.service;

import com.example.nikita.repository.ProjectRepository;
import com.example.nikita.dto.ProjectDTO;
import com.example.nikita.entity.Project;
import com.example.nikita.exception_handling.NoSuchEmployeeException;
import com.example.nikita.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMapper projectMapper;

    public void deleteEmployee(int id) {
        projectRepository.deleteById(id);
    }

    public ProjectDTO getProject(int id) {
        Optional<Project> optionalEmployee1 = projectRepository.findById(id);

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
