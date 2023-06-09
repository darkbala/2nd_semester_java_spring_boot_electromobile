package com.courseWork.electomobile.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String homeView(Model model) {
        model.addAttribute("title", "About Page");
        return "about";
    }
}