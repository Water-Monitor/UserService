package watermonitor.userservice.models.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Response<S extends Dto, T extends ErrorDto> {
    private S data;
    private T error;
}
