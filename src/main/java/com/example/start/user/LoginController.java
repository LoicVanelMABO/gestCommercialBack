package com.example.start.user;

import com.example.start.user.UserEntity;
import com.example.start.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("")
public class LoginController {

    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserEntity credentials, HttpSession session) {
        UserEntity user = userService.login(credentials.getUserName(), credentials.getPwd());
        if (user != null) {
            // Create session attribute
            session.setAttribute("user", user);
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return ResponseEntity.ok("Logged out successfully.");
    }
    @PostMapping(path = "/signup" ,consumes = APPLICATION_JSON_VALUE)
    public UserEntity create(@RequestBody UserEntity credentials){
        RoleEntity role = new RoleEntity();
        role.setName("1er role");
        UserEntity user = new UserEntity();
        user.setUserName(credentials.getUserName());
        user.setNom(credentials.getNom());
        user.setPwd(credentials.getPwd());
        user.setEmail(credentials.getEmail());
        user.setRole(role);
        user.setlastConnection(LocalDateTime.now());

        System.out.println(credentials.getUserName());
        return userService.save(user);
    }
}