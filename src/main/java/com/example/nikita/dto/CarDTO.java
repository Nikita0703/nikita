package com.example.nikita.dto;

public class CarDTO {

    private int id;
    private String model;
    private int made;

    public CarDTO(int id, String model, int made) {
        this.id = id;
        this.model = model;
        this.made = made;
    }

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
