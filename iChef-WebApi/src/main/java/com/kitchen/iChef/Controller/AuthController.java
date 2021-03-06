package com.kitchen.iChef.Controller;

import com.kitchen.iChef.Mapper.SignUpMapper;
import com.kitchen.iChef.Controller.Model.Request.LogInRequest;
import com.kitchen.iChef.Controller.Model.Request.SignUpRequest;
import com.kitchen.iChef.Domain.Token;
import com.kitchen.iChef.Service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class AuthController {
    private static final Logger LOGGER = LogManager.getLogger();
    private final SignUpMapper signUpMapper;
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
        this.signUpMapper = new SignUpMapper();
    }

    @PostMapping(value = "/sign-up")
    public void signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        LOGGER.info("Signing up {}", signUpRequest.getEmail());
        userService.signUp(signUpMapper.mapFromRequest(signUpRequest));
    }

    @PostMapping(value = "/login")
    public Token login(@Valid @RequestBody LogInRequest logInRequest) {
        LOGGER.info("Logging in {}", logInRequest.getEmail());
        return userService.login(logInRequest.getEmail(), logInRequest.getPassword());
    }
}
