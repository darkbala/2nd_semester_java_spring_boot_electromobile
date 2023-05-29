package com.courseWork.electomobile.Controllers;

import com.courseWork.electomobile.Services.CarService;
import com.courseWork.electomobile.Services.NewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
@RequiredArgsConstructor
public class MainController {
    private final NewService newService;
    private final CarService carService;

    @GetMapping("/")
    public String homeView(Model model) {
        model.addAttribute("news", newService.newsList());
        model.addAttribute("cars", carService.carsList());
        return "home";
    }
}