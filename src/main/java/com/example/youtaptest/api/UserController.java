package com.example.youtaptest.api;

import com.example.youtaptest.model.User;
import com.example.youtaptest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getusercontacts")
    public ResponseEntity<Object> getUser(@RequestParam(required = false) Optional<Integer> id, @RequestParam(required = false) Optional<String> username, @RequestParam Map<String, String> allParams) {

        if (allParams.isEmpty()) {// get all users
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } else if (allParams.size() > 1) {
            return new ResponseEntity<>("Too many params", HttpStatus.BAD_REQUEST);
        } else if (id.isPresent()) {
            return new ResponseEntity<>(userService.getUserById(id.get()).orElse(new User()), HttpStatus.OK);
        } else if (username.isPresent()) {
            return new ResponseEntity<>(userService.getUserByUsername(username.get()).orElse(new User()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
    }
}

