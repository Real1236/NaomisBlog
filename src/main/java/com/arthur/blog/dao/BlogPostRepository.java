package com.arthur.blog.dao;

import com.arthur.blog.entity.BlogPost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogPostRepository extends CrudRepository<BlogPost, Integer> {

    List<BlogPost> findAllByOrderByDateDesc();

}
