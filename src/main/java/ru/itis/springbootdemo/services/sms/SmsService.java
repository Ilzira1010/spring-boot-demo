package ru.itis.springbootdemo.services.sms;

import org.springframework.stereotype.Component;

public interface SmsService {
    void sendSms(String phone, String text);
}
