package org.oocl.todolistbackend.pojo;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "Unprocessable Entity")
    @NotNull(message = "Unprocessable Entity")
    private String text;
    private boolean done;
    public Todo(String text, boolean done) {
        this.text = text;
        this.done = done;
    }
}
