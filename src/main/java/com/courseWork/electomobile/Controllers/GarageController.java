package com.courseWork.electomobile.Controllers;

import com.courseWork.electomobile.Models.CarModel;
import com.courseWork.electomobile.Services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class GarageController {
    private final CarService carService;

    @GetMapping("/garage")
    public String cars(Model model){
        model.addAttribute("cars", carService.carsList());
        return "garage";
    }

    @GetMapping("/garage/{id}")
    public String carInfo(@PathVariable Long id, Model model){
        model.addAttribute("car", carService.getCarById(id));
        return "car-more";
    }



    @GetMapping("/garage/create")
    public String newsAddView(Model model) {
        return "cars-add";
    }

    @PostMapping("/garage/create")
    public String createCar(CarModel car){
        carService.saveCar(car);
        return "redirect:/garage";
    }

    @PostMapping("/garage/delete/{id}")
    public String deleteCar(@PathVariable Long id){
        carService.deleteCar(id);
        return "redirect:/garage";
    }
}