package com.api.vendas_track.adapters.in.controller;

import com.api.vendas_track.application.useCases.UserUseCases;
import com.api.vendas_track.domain.user.CreateUserDto;
import com.api.vendas_track.domain.user.LoginDto;
import com.api.vendas_track.domain.user.ViewUserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserUseCases userService;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Void> create(@RequestBody @Valid CreateUserDto dto) {
        userService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{id}")
    @CrossOrigin
    public ResponseEntity<ViewUserDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody LoginDto dto){
        return ResponseEntity.ok(this.userService.authenticateUser(dto));
    }

}
