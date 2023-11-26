package com.example.nikita.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public class HouseDTO {

   @JsonView(View.Employee.class)
    private String adress;

    @JsonView(View.Employee.class)
    private int flour;

    @JsonView(View.Employee.class)
    private int flat;

    public HouseDTO( String adress, int flour, int flat) {
        this.adress = adress;
        this.flour = flour;
        this.flat = flat;
    }

    public HouseDTO(){};

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
