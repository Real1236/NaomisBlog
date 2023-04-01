package com.arthur.blog.dao;

import com.arthur.blog.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface LikeRepository extends CrudRepository<UserEntity, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO likes (user_id, blogpost_id) VALUES (?1, ?2)", nativeQuery = true)
    void addLike(Integer userId, Integer blogpostId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM likes WHERE (user_id = ?1) and (blogpost_id = ?2)", nativeQuery = true)
    void removeLike(Integer userId, Integer blogpostId);

}
