package pl.tymek.ToDoList.Service;


import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendReminder(String to, String subject, String text){

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);
            mailSender.send(message);
        }
        catch (MessagingException e){
            throw new RuntimeException("Błąd podczas wysyłania maila HTML", e);
        }
    }
//    @PostConstruct
//    public void testEmai(){
//        sendReminder("karol.milanowski91@gmail.com", "Test", "Próba wysłania maila z aplikacji");
//    }

}
