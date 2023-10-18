package com.example.nikita.entity;

import com.example.nikita.dto.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "car_for_empl")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonView(View.Employee.class)
    private int id;
    @JsonView(View.Employee.class)
    @Column(name = "model")
    private String model;

    @JsonView(View.Employee.class)
    @Column(name = "made")
    private int made;

    public Car(String model, int made) {
        this.model = model;
        this.made = made;
    }

    public Car(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMade() {
        return made;
    }

    public void setMade(int made) {
        this.made = made;
    }
}
