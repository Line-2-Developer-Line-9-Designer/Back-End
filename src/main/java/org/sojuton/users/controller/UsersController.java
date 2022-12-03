package org.sojuton.users.controller;

import lombok.RequiredArgsConstructor;
import org.sojuton.users.model.dto.UsersDto;
import org.sojuton.users.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody UsersDto usersDto) {
        return ResponseEntity.ok(usersService.signUp(usersDto));
    }

    @PostMapping("/signIn")
    public ResponseEntity signIn(@RequestBody UsersDto usersDto, HttpServletResponse response) {
        return ResponseEntity.ok(usersService.signIn(usersDto, response));
    }

    @GetMapping
    public ResponseEntity getUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(usersService.getUserInfo(request));
    }
    @GetMapping("/duplicateCheck")
    public ResponseEntity duplicateCheck(@RequestBody UsersDto usersDto) {
        return ResponseEntity.ok(usersService.duplicateCheck(usersDto));
    }


}
