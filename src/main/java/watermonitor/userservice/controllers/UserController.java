package watermonitor.userservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import watermonitor.userservice.models.dto.Response;
import watermonitor.userservice.models.dto.send_in.CreateUserDto;
import watermonitor.userservice.models.dto.send_out.UserDto;
import watermonitor.userservice.services.UserService;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody CreateUserDto userCreateRequest) {
        UserDto user = userService.createUser(userCreateRequest);

        if (user == null) {
            log.info("failed");
            return ResponseEntity.badRequest().build();
        }

        log.info("user created with name: " + user.getName());
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("")
    public ResponseEntity getLoggedInUser() {
        Optional<UserDto> loggedInUser = userService.getLoggedInUser();

        if (!loggedInUser.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Response wrapper = Response.builder().data(loggedInUser.get()).build();
        return ResponseEntity.ok(wrapper);
    }
}