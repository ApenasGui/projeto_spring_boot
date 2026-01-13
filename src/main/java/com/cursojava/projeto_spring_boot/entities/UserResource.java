package com.cursojava.projeto_spring_boot.entities;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User("Melina", "melina@email.teste", "9999999", "123123qwe", 1L);
        return ResponseEntity.ok().body(u);
    }
}
