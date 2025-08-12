package dev.project.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dev.project.api.dto.UserDTO;
import dev.project.api.service.UserService;
import jakarta.validation.Valid;

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity postUser(@RequestBody @Valid UserDTO user) {
        userService.insert(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
