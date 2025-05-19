package pl.tymek.ToDoList.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.tymek.ToDoList.Service.RemindItemService;
import pl.tymek.ToDoList.entity.RemindItem;
import pl.tymek.ToDoList.entity.RemindType;

import java.util.Optional;

@Controller
public class RemindItemController {

    public RemindItemController(RemindItemService service) {
        this.service = service;
    }

    private RemindItemService service;


    @GetMapping({"/","display","home"})
    public String displayAllItems(Model model){
        model.addAttribute("remindItems", service.getAllRemindItem());
        model.addAttribute("remindItem", new RemindItem());
        model.addAttribute("types", RemindType.values());
        return "display_all";
    }
    @PostMapping("/add")
    public String addItem(@ModelAttribute RemindItem item){
        service.saveRemindItem(item);
        return "redirect:/display";
    }
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id){
        service.deleteRemindItemById(id);
        return "redirect:/display";
    }
    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model) {
        RemindItem item = service.findById(id).orElse(new RemindItem());
        model.addAttribute("remindItem", item);
        model.addAttribute("remindItems", service.getAllRemindItem());
        model.addAttribute("types", RemindType.values());
        model.addAttribute("editMode", true);
        return "display_all";
    }

}
