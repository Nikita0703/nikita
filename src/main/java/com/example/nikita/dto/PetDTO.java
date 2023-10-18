package com.example.nikita.dto;

public class PetDTO {
    private int id;

    private String vid;

    private String petname;

    public PetDTO(int id, String vid, String petname) {
        this.id = id;
        this.vid = vid;
        this.petname = petname;
    }

    public PetDTO(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
