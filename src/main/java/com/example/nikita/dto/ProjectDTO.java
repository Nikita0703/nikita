package com.example.nikita.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;
@Builder
public class ProjectDTO {

    @JsonView(View.Employee.class)
    private String title;

    @JsonView(View.Employee.class)
    private int year;

    @JsonView(View.Project.class)
    private List<EmployeeDTO> employees;

    public ProjectDTO(String title, int year, List<EmployeeDTO> employees) {
        this.title = title;
        this.year = year;
        this.employees = employees;
    }

    public ProjectDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }


}
