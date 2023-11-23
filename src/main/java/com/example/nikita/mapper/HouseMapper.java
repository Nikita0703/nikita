package com.example.nikita.mapper;

import com.example.nikita.dto.HouseDTO;
import com.example.nikita.entity.House;
import org.springframework.stereotype.Component;

@Component
public class HouseMapper {

    public House toHouse(HouseDTO houseDTO){
        House house = House.builder()
                .adress(houseDTO.getAdress())
                .flour(houseDTO.getFlour())
                .flat(houseDTO.getFlat())
                .build();
        return house;
    }

    public HouseDTO toHouseDTO(House house){
        HouseDTO houseDTO = HouseDTO.builder()
                .adress(house.getAdress())
                .flour(house.getFlour())
                .flat(house.getFlat())
                .build();
        return houseDTO;
    }


}
