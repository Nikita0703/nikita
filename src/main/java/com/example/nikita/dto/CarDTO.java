package com.example.nikita.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public class CarDTO {

    //private int id;
    @JsonView(View.Employee.class)
    private String model;
    @JsonView(View.Employee.class)
    private int made;

    public CarDTO(String model, int made) {
      //  this.id = id;
        this.model = model;
        this.made = made;
    }

   // public int getId() {
      //  return id;
   // }

  //  public void setId(int id) {
     //   this.id = id;
   // }

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
