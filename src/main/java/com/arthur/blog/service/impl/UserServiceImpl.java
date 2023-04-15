package com.arthur.blog.service.impl;

import com.arthur.blog.dao.GroupRepository;
import com.arthur.blog.dao.UserRepository;
import com.arthur.blog.dto.UserDTO;
import com.arthur.blog.entity.Group;
import com.arthur.blog.entity.UserEntity;
import com.arthur.blog.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    GroupRepository groupRepository;

    PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, GroupRepository groupRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(UserDTO userData) {
        UserEntity newUserEntity = new UserEntity();
        BeanUtils.copyProperties(userData, newUserEntity);
        encodePassword(userData, newUserEntity);
        updateReaderGroup(newUserEntity);
        userRepository.save(newUserEntity);
    }

    private void updateReaderGroup(UserEntity userEntity){
        Group group = groupRepository.findByCode("reader");
        userEntity.addUserGroups(group);
    }

    private void encodePassword(UserDTO source, UserEntity target){
        target.setPassword(passwordEncoder.encode(source.getPassword()));
    }

    @Override
    public UserEntity findById(int id) {
        return userRepository.findById(id);
    }
}
