package com.example.start.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    UserEntity findByUserNameAndPwd(String userName, String pwd);
}
