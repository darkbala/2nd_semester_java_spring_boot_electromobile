package com.courseWork.electomobile.Services;

import com.courseWork.electomobile.Models.CarModel;
import com.courseWork.electomobile.Repo.CarRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {
    private final CarRepo carRepo;
    private List<CarModel> cars = new ArrayList<>();

    public List<CarModel> carsList(){
        List<CarModel> cars = carRepo.findAll();
        return cars;
    }
    public void saveCar(CarModel car){
        carRepo.save(car);
    }
    public void deleteCar(Long id){
        carRepo.deleteById(id);
    }

    public CarModel getCarById(Long id){
        return carRepo.findById(id).orElse(null);
    }

}
