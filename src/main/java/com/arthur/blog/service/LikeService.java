package com.arthur.blog.service;

public interface LikeService {
     void addLike(int userId, int blogPostId);
     void removeLike(Integer userId, Integer blogPostId);
}
