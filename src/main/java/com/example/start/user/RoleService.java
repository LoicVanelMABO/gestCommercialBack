package com.example.start.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleEntity> findAll(){
        return (List<RoleEntity>) roleRepository.findAll();
    }
    public Optional<RoleEntity> findById(Integer id){
        return roleRepository.findById(id);
    }
    public RoleEntity save(RoleEntity role){
        return  roleRepository.save(role);
    }

    public void deleteById(Integer id){
        roleRepository.deleteById(id);
    }
}
