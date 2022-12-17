package project1.Model;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Student {

    @NotNull( message = "name shouldn't be empty")
    private String name;

    @NotNull( message = "ID shouldn't be empty")
    private Integer ID;

    @NotNull( message = "Age shouldn't be empty")
    private int age;

    @NotNull( message = "Major shouldn't be empty")
    @Pattern(regexp = "(Math|CS|Engineering)", message = "Major has to be CS, Math or Engineering.")
    private String major;
}
