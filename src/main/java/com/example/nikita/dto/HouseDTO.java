package com.example.nikita.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public class HouseDTO {
   // private int id;
   @JsonView(View.Employee.class)
    private String adress;
    @JsonView(View.Employee.class)

    private int flour;
    @JsonView(View.Employee.class)
    private int flat;

    public HouseDTO( String adress, int flour, int flat) {
      //  this.id = id;
        this.adress = adress;
        this.flour = flour;
        this.flat = flat;
    }

    public HouseDTO(){};

  //  public int getId() {
        //return id;
 //   }

    //public void setId(int id) {
        //this.id = id;
   // }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getFlour() {
        return flour;
    }

    public void setFlour(int flour) {
        this.flour = flour;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }
}
