package com.courseWork.electomobile.Helpers;

import org.springframework.stereotype.Component;

@Component
public class SmsSender {

    public void sendSms(String phoneNumber, String message) {
        // Реализация отправки SMS-сообщения на указанный номер телефона
        // Вставьте здесь код для отправки SMS
        System.out.println("Sending SMS to: " + phoneNumber);
        System.out.println("Message: " + message);
    }
}
