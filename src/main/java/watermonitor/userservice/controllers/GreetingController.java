package watermonitor.userservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import watermonitor.userservice.models.dto.send_out.Greeting;

@RestController
@RequestMapping("/")
public class GreetingController {
    @GetMapping("greeting")
    public Greeting testConnection()
    {
        return new Greeting("UserService", "You are connected and received this response");
    }
}
