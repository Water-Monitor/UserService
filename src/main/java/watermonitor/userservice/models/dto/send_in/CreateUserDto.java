package watermonitor.userservice.models.dto.send_in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import watermonitor.userservice.models.dto.Dto;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserDto implements Dto {
    private String name;
    private String username;
    private String password;
}