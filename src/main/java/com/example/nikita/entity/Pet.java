package com.example.nikita.entity;

import com.example.nikita.dto.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

    @Entity
    @Table(name = "pets_for_empl")
    @Builder
    @AllArgsConstructor
    public class Pet {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "vid")
        private String vid;

        @Column(name = "petname")
        private String petname;

        public Pet(String vid, String petname) {
            this.vid = vid;
            this.petname = petname;
        }

        public Pet(){};

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
