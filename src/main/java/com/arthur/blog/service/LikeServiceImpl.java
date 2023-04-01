package com.arthur.blog.service;

import com.arthur.blog.dao.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    LikeRepository likeRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public void addLike(int userId, int blogPostId) {
        likeRepository.addLike(userId, blogPostId);
    }

    @Override
    public void removeLike(Integer userId, Integer blogPostId) {
        likeRepository.removeLike(userId, blogPostId);
    }
}
