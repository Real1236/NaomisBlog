package com.arthur.blog.dao;

import com.arthur.blog.entity.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepository extends CrudRepository<Group, Integer> {
    Group findByCode(String code);
}
