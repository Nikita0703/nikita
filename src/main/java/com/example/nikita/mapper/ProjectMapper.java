package com.example.nikita.mapper;

import com.example.nikita.dto.PetDTO;
import com.example.nikita.dto.ProjectDTO;
import com.example.nikita.dto.View;
import com.example.nikita.entity.Pet;
import com.example.nikita.entity.Project;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<ProjectDTO> toProjectDTOList(List<Project> projects) {
        List<ProjectDTO> projectsDTOList = new ArrayList<>();
        for (Project project : projects) {
            ProjectDTO projectDTO = ProjectDTO.builder().
                    id(project.getId()).
                    title(project.getTitle())
                    .year(project.getYear()).
                    build();
            projectsDTOList.add(projectDTO);
        }
        return projectsDTOList;
    }

    public List<Project> toProjectList(List<ProjectDTO> projectDTOS) {
        List<Project> projects = new ArrayList<>();
        for (ProjectDTO projectDTO : projectDTOS) {
            Project project = Project.builder().
                    id(projectDTO.getId()).
                    title(projectDTO.getTitle())
                    .year(projectDTO.getYear()).
                    build();
            projects.add(project);
        }
        return projects;
    }
}
