package ru.itis.springbootdemo.services.mail;

import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import ru.itis.springbootdemo.models.State;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class MailsServiceImpl implements MailsService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UsersRepository usersRepository;

    @Value("${spring.mail.username}")
    private String mailFrom;

    private final Template confirmMailTemplate;

    public MailsServiceImpl() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateLoader(
                new SpringTemplateLoader(new ClassRelativeResourceLoader(this.getClass()),
                        "/"));
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        try {
            this.confirmMailTemplate =configuration.getTemplate("mail/confirm_mail.ftlh");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
    @Override
    public void sendEmailForConfirm(String email, String code) {
        String mailText = getEmailText(code);
        MimeMessagePreparator messagePreparator = getEmail(email, mailText);
        javaMailSender.send(messagePreparator);
    }

    private MimeMessagePreparator getEmail(String email, String mailText) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(mailFrom);
            messageHelper.setTo(email);
            messageHelper.setSubject("Регистрация");
            messageHelper.setText(mailText, true);
        };
        return messagePreparator;
    }

    private String getEmailText(String code) {
        // подготовили данные для шаблона
        Map<String, String> attributes = new HashMap<>();
        attributes.put("confirm_code", code);

        StringWriter writer = new StringWriter();
        try {
            // записали в StringWriter текст сообщения
            confirmMailTemplate.process(attributes, writer);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException(e);
        }
        // получили текст сообщения из шаблона
        return writer.toString();
    }

    @Override
    public Boolean isConfirmed(String code){
        Optional<User> user = usersRepository.findByConfirmCode(code);
        if (user.isPresent()) {
//            user.get().setConfirmCode(code);
            user.get().setState(State.CONFIRMED);
            usersRepository.save(user.get());
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
//    @Override
//    public void findUserByCode(String code) {
//        Optional<User> confirmCode = usersRepository.findByConfirmCode(code);
//        User user = User.builder()
//                .id(confirmCode.get().getId())
//                .nickname(confirmCode.get().getNickname())
//                .email(confirmCode.get().getEmail())
//                .hashPassword(confirmCode.get().getHashPassword())
//                .phone(confirmCode.get().getPhone())
//                .state(State.CONFIRMED)
//                .build();
//        usersRepository.save(user);
//    }
}
