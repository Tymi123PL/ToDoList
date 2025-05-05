package pl.tymek.ToDoList.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class RemindItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private RemindType type;

}
