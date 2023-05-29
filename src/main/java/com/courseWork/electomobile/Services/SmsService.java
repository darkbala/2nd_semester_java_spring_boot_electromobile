package com.courseWork.electomobile.Services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String phoneNumber;

    public void sendSms(String toPhoneNumber, String message) {
        Twilio.init(accountSid, authToken);

        Message sms = Message.creator(
                        new PhoneNumber(toPhoneNumber),
                        new PhoneNumber(phoneNumber),
                        message)
                .create();

        System.out.println("SMS sent: " + sms.getSid());
    }
}
