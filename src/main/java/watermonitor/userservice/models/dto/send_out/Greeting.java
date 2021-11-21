package watermonitor.userservice.models.dto.send_out;

import lombok.AllArgsConstructor;
import lombok.Getter;
import watermonitor.userservice.models.dto.Dto;

@Getter
@AllArgsConstructor
public class Greeting implements Dto {
    private String service;
    private String message;
}
