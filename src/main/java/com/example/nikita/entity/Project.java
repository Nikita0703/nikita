package com.example.nikita.entity;


import com.example.nikita.dto.View;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects_for_empl")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(View.Employee.class)
    private int id;

    @JsonView(View.Employee.class)
    @Column(name = "title")
    private String title;

    @JsonView(View.Employee.class)
    @Column(name = "year")
    private int year;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "emps_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<Employee> projects = new ArrayList<>();

    public Project(String title,int year){
        this.title=title;
        this.year=year;
    }

    public Project(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Employee> getProjects() {
        return projects;
    }

    public void setProjects(List<Employee> projects) {
        this.projects = projects;
    }
}
