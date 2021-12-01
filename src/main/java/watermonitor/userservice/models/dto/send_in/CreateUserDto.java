package watermonitor.userservice.models.dto.send_in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import watermonitor.userservice.models.dto.Dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserDto implements Dto {
    @NotNull(message = "cannot be null")
    @Size(min = 8, max = 200)
    private String name;
    @NotNull(message = "cannot be null")
    @Size(min = 8, max = 200)
    private String username;
//    @Email(regexp=".*@.*\\..*", message = "Email should be valid")
//    private String email;
    @NotNull(message = "cannot be null")
    @Size(min = 8, max = 200)
    private String password;
}