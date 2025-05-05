package pl.tymek.ToDoList.repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tymek.ToDoList.entity.RemindItem;
@Repository
public interface RemindItemRepository extends JpaRepository<RemindItem, Long> {
}
