package com.example.start.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    //create a role
    @ResponseStatus(HttpStatus.CREATED)//201
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public UserEntity create(@RequestBody UserEntity user){
        return userService.save(user);
    }

    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)//204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        userService.deleteById(id);
    }

    @GetMapping(path = "/sur")
    public String createUser(){
        userService.creerRoleWithUser();
        return "ok";
    }
}
