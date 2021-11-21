package watermonitor.userservice.models.dto.send_out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import watermonitor.userservice.models.dto.Dto;

@Getter
@Setter
@AllArgsConstructor
public class UserDto implements Dto {
    private long id;
    private String title;
    private String content;
}