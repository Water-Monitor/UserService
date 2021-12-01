package watermonitor.userservice.models.dto.send_out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import watermonitor.userservice.models.dto.Dto;

import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto implements Dto {
    private long id;
    private String name;
    private String username;
    private List<String> roles;
}