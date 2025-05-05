package pl.tymek.ToDoList.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.tymek.ToDoList.Service.RemindItemService;

@Controller
public class RemindItemController {
    private RemindItemService service;


    @GetMapping("/display")
    public String displayAllItems(Model model){
        model.addAttribute("remindItems", service.getAllRemindItem());
        return "display_all";
    }
}
