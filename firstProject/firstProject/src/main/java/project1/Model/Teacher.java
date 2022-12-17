package project1.Model;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Teacher {

    @NotNull( message = "name shouldn't be empty")
    private String name;

    @NotNull( message = "ID shouldn't be empty")
    private Integer ID;

    @NotNull( message = "Salary shouldn't be empty")
    private double salary;
}
