package com.example.nikita.entity;

import com.example.nikita.dto.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;


    @Entity
    @Table(name = "house_for_empl")
    public class House {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        @JsonView(View.Employee.class)
        private int id;
        @JsonView(View.Employee.class)
        @Column(name = "adress")
        private String adress;

        @JsonView(View.Employee.class)
        @Column(name = "flour")
        private int flour;

        @JsonView(View.Employee.class)
        @Column(name = "flat")
        private int flat;

        public House(String adress, int flour, int flat) {
            this.adress = adress;
            this.flour = flour;
            this.flat = flat;
        }

        public House(){};

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

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