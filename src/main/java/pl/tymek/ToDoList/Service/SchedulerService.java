package pl.tymek.ToDoList.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.tymek.ToDoList.entity.RemindItem;

import java.time.LocalDate;
import java.util.List;

@Service
public class SchedulerService {
    private RemindItemService remindItemservice;
    private EmailService emailService;

    public SchedulerService(RemindItemService remindItemservice, EmailService emailService) {
        this.remindItemservice = remindItemservice;
        this.emailService = emailService;
    }

    @Scheduled(cron = "30 59 19 * * *")
    public void dailyRemainder()
    {
        System.out.println("Sprawdzam powiadomienia...");
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        List<RemindItem> allRemindItem = remindItemservice.getAllRemindItem();
        for(RemindItem item : allRemindItem){
            try {
                if (item.getDate().toLocalDate().equals(tomorrow)) {
                    String subject = "📅 Jutrzejsze wydarzenie: " + item.getName();

                    String htmlBody = """
                        <html>
                        <body>
                        <h1>Przypomnienie o wydarzeniu</h1>
                        <hr>
                        <p>Cześć!</p>
                        <p><h5>Oto twoje przypomnienie o wydarzeniu:<strong>%s</strong></h5></p>
                        <p>Opis wydarzenia:</p>
                        <p><h6>%s</h6></p>
                        <p>Sprawdz liste pozostałych wydarzeń <a href="http://localhost:8080"> TUTAJ </a></p>
                        
                        </html>
                    """.formatted(item.getName(), item.getDescription());

                    emailService.sendReminder("tymon.pierzchot@gmail.com", subject, htmlBody);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
