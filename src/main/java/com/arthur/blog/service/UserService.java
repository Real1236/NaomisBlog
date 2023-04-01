package com.arthur.blog.service;

import com.arthur.blog.dto.UserDTO;
import com.arthur.blog.entity.UserEntity;

public interface UserService {

    void register(final UserDTO user);

    UserEntity getUserByUsername(String username);
}
