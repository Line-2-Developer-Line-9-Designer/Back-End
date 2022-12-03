package org.sojuton.users.controller;

import lombok.RequiredArgsConstructor;
import org.sojuton.users.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping
    public ResponseEntity login() {
        return ResponseEntity.ok(usersService.login());
    }
}
