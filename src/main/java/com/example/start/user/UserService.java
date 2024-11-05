package com.example.start.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public List<UserEntity> findAll(){
        return (List<UserEntity>) userRepository.findAll();
    }
    public Optional<UserEntity> findById(Integer id){
        return userRepository.findById(id);
    }

    public UserEntity save(UserEntity user){
        return  userRepository.save(user);
    }
    public void creerRoleWithUser(){
        RoleEntity role = new RoleEntity();
        role.setName("role 2");
        RoleEntity r2 = roleRepository.save(role);

        UserEntity newUser = new UserEntity();
        newUser.setRole(r2);
        newUser.setEmail("sbhg@gmail.com");
        newUser.setlastConnection(LocalDateTime.now());
        newUser.setNom("ddd");
        newUser.setPwd("ddd");
        newUser.setUserName("ddd");
        userRepository.save(newUser);
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

    public UserService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public UserEntity login(String userName, String pwd){
        return userRepository.findByUserNameAndPwd(userName,pwd);

    }
}
