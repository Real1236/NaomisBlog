package com.arthur.blog.service;

import com.arthur.blog.entity.BlogPost;

import java.util.Optional;

public interface BlogPostService {
    BlogPost save(BlogPost blogPost);

    Iterable<BlogPost> saveAll(Iterable<BlogPost> blogPosts);

    Optional<BlogPost> findById(Integer id);

    boolean existsById(Integer id);

    Iterable<BlogPost> findAll();

    Iterable<BlogPost> findAllById(Iterable<Integer> ids);

    long count();

    void deleteById(Integer id);

    void delete(BlogPost blogPost);

    void deleteAllById(Iterable<? extends Integer> ids);

    void deleteAll(Iterable<? extends BlogPost> entities);

    void deleteAll();
}
