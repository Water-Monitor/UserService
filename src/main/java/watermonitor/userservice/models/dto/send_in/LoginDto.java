package watermonitor.userservice.models.dto.send_in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import watermonitor.userservice.models.dto.Dto;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto implements Dto {
    private String username;
    private String password;
}