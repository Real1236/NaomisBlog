package com.arthur.blog.dao;

import com.arthur.blog.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUsername(String username);

}
