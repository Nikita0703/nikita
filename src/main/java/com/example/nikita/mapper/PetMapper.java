package com.example.nikita.mapper;

import com.example.nikita.dto.PetDTO;
import com.example.nikita.entity.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {
    public Pet toPet(PetDTO petDTO){
        Pet pet = Pet.builder().
                id(petDTO.getId()).
                vid(petDTO.getVid())
                .petname(petDTO.getName()).
                build();
        return pet;
    }

    public PetDTO toPetDTO(Pet pet){
        PetDTO petDTO = PetDTO.builder().
                id(pet.getId()).
                vid(pet.getVid())
                .petname(pet.getName()).
                build();
        return petDTO;
    }
}
