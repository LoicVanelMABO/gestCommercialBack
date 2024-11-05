package com.example.start.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<RoleEntity> findAll(){
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<RoleEntity> findById(@PathVariable Integer id){
        return roleService.findById(id);
    }

    //create a role
    @ResponseStatus(HttpStatus.CREATED)//201
    @PostMapping
    public RoleEntity create(@RequestBody RoleEntity role){
        return roleService.save(role);
    }

    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)//204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        roleService.deleteById(id);
    }
}
