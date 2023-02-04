package com.arthur.blog.dao;

import com.arthur.blog.entity.BlogPost;
import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<BlogPost, Integer> {

}
