package lucas.ifmg.produtos.services;

import lucas.ifmg.produtos.dto.EmailDto;
import lucas.ifmg.produtos.services.exceptions.EmailException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String EmailService;

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(EmailDto emailDTO) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(EmailService);
            message.setTo(emailDTO.getTo());
            message.setSubject(emailDTO.getSubject());
            message.setText(emailDTO.getBody());
            mailSender.send(message);
        } catch (MailSendException e) {
            throw new EmailException(e.getMessage());
        }
    }
}
