package com.example.nikita.mapper;

import com.example.nikita.dto.PetDTO;
import com.example.nikita.entity.Pet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<PetDTO> toPetDTOList(List<Pet> pets){
       List<PetDTO> petDTOList = new ArrayList<>();
        for(Pet pet:pets){
            PetDTO petDTO = PetDTO.builder().
                    id(pet.getId()).
                    vid(pet.getVid())
                    .petname(pet.getName()).
                    build();
            petDTOList.add(petDTO);
        }
        return petDTOList;
    }

    public List<Pet> toPetList(List<PetDTO> petDTOList){
        List<Pet> pets = new ArrayList<>();
        for(PetDTO petDTO:petDTOList){
            Pet pet = Pet.builder().
                    id(petDTO.getId()).
                    vid(petDTO.getVid())
                    .petname(petDTO.getName()).
                    build();
            pets.add(pet);
        }
        return pets;
    }
}
