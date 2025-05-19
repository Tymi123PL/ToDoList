package pl.tymek.ToDoList.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.tymek.ToDoList.Service.RemindItemService;
import pl.tymek.ToDoList.entity.RemindItem;
import pl.tymek.ToDoList.entity.RemindType;

@Controller
public class RemindItemController {
    private RemindItemService service;


    @GetMapping("/display")
    public String displayAllItems(Model model){
        model.addAttribute("remindItems", service.getAllRemindItem());
        model.addAttribute("remindItem", new RemindItem());
        model.addAttribute("types", RemindType.values());
        return "display_all";
    }

}
