package com.example.nikita.mapper;

import com.example.nikita.dto.ProjectDTO;
import com.example.nikita.dto.View;
import com.example.nikita.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public Project toProject(ProjectDTO projectDTO){
        Project project = Project.builder().
                id(projectDTO.getId()).
                title(projectDTO.getTitle())
                .year(projectDTO.getYear()).
                build();
        return project;
    }

    public ProjectDTO toProjectDTO(Project project){
        ProjectDTO projectDTO = ProjectDTO.builder().
                id(project.getId()).
                title(project.getTitle())
                .year(project.getYear()).
                build();
        return projectDTO;
    }
}
