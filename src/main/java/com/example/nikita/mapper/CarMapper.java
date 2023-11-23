package com.example.nikita.mapper;

import com.example.nikita.dto.CarDTO;
import com.example.nikita.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public Car toCar(CarDTO carDTO){
        Car car = Car.builder().
                model(carDTO.getModel())
                .made(carDTO.getMade()).
                build();
        return car;
    }

    public CarDTO toCarDTO(Car car){
        CarDTO carDTO = CarDTO.builder().
                model(car.getModel())
                .made(car.getMade()).
                build();
        return carDTO;
    }
}
