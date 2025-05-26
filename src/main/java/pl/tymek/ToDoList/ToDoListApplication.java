package pl.tymek.ToDoList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.tymek.ToDoList.entity.RemindType;

@EnableScheduling
@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoListApplication.class, args);
	}

}
