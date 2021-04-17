package ru.itis.springbootdemo.services.mail;

public interface MailsService {
    void sendEmailForConfirm(String email, String code);
//    void findUserByCode(String code);
    Boolean isConfirmed(String code);
}
