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

    @Scheduled(cron = "0 18 20 * * *")
    public void dailyRemainder()
    {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        List<RemindItem> allRemindItem = remindItemservice.getAllRemindItem();
        for(RemindItem item : allRemindItem){
            try {
                if (item.getDate().toLocalDate().equals(tomorrow)) {
                    emailService.sendReminder("tymon.pierzchot@gmail.com", "Jutrzejsze wydarzenie: "+item.getName(), "Oto twoje przypomnienie, że jutro ma miejsce następujące wydarzenie:\n"+item.getDescription());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
