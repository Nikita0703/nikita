package com.example.nikita.service;

import com.example.nikita.dao.EmployeeDAO;
import com.example.nikita.dao.ProjectDAO;
import com.example.nikita.entity.Employee;
import com.example.nikita.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceimpl {
    @Autowired
    private ProjectDAO projectDAO;



    public List<Project> getAllProjects() {
        return projectDAO.findAll();
    }


    public Project saveProject(Project employee) {
        return projectDAO.save(employee);
    }



    public Project getProject(int id) {
        Optional<Project> optionalProject = projectDAO.findById(id);
        return optionalProject.orElse(null);
    }



    public void deleteProject(int id) {
        projectDAO.deleteById(id);
    }

    /// @Override
    //  public void update(int id){
    //Employee employee=employeeDAO.findById(id).get();
    // }

}
