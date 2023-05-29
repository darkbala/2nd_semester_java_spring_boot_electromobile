package com.courseWork.electomobile.Controllers;

import com.courseWork.electomobile.Helpers.SmsSender;
import com.courseWork.electomobile.Models.TestDriveForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TestDriveController {
    private final SmsSender smsSender;

    @GetMapping("/test")
    public String smsForm(Model model) {
        return "test-form";
    }

    @PostMapping("/test")
    public String submitTestDriveForm(@ModelAttribute("testDriveForm") TestDriveForm testDriveForm) {
        String fullName = testDriveForm.getFirstName() + " " + testDriveForm.getLastName();
        String phoneNumber = testDriveForm.getPhoneNumber();

        // Логика отправки электронной почты
        String recipientEmail = "recipient@example.com";
        String subject = "Запись на тест-драйв";
        String content = "Здравствуйте, " + fullName + "! Мы вас записали на тест-драйв. Приходите в офис для проведения тест-драйва";

    return "redirect:/";



    }

}
