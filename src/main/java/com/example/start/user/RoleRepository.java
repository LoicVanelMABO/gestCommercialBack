package com.example.start.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {

}
