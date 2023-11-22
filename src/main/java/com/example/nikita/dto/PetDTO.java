package com.example.nikita.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Getter;

@Builder
public class PetDTO {

    @Getter
    @JsonView(View.Employee.class)
    private int id;

    @JsonView(View.Employee.class)
    private String vid;

    @JsonView(View.Employee.class)
    private String petname;

    public PetDTO(int id, String vid, String petname) {
        this.id = id;
        this.vid = vid;
        this.petname = petname;
    }

    public PetDTO(String vid, String petname) {
        this.vid = vid;
        this.petname = petname;
    }

    public PetDTO(){};

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getName() {
        return petname;
    }

    public void setName(String name) {
        this.petname = name;
    }

    public void setId(int id) {
        this.id = id;
    }

}
