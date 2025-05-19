package pl.tymek.ToDoList.Service;

import org.springframework.stereotype.Service;
import pl.tymek.ToDoList.entity.RemindItem;
import pl.tymek.ToDoList.repository.RemindItemRepository;

import java.util.List;

@Service
public class RemindItemService {

    private RemindItemRepository repository;

    public RemindItemService(RemindItemRepository repository) {
        this.repository = repository;
    }

    public List<RemindItem> getAllRemindItem() {
        return repository.findAll();
    }

    public void saveRemindItem(RemindItem remindItem) {
        repository.save(remindItem);
    }
    public void deleteRemindItemById(Long id){
        repository.deleteById(id);
    }

}
