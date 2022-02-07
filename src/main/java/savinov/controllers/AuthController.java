package savinov.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/auth")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String getAuth() {
        return "Welcome!";
    }
}
