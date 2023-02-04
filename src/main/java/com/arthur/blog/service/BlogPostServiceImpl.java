package com.arthur.blog.service;

import com.arthur.blog.dao.BlogPostRepository;
import com.arthur.blog.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogPostServiceImpl implements BlogPostService {

    BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public BlogPost save(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public Iterable<BlogPost> saveAll(Iterable<BlogPost> blogPosts) {
        return blogPostRepository.saveAll(blogPosts);
    }

    @Override
    public Optional<BlogPost> findById(Integer id) {
        return blogPostRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return blogPostRepository.existsById(id);
    }

    @Override
    public Iterable<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }

    @Override
    public Iterable<BlogPost> findAllById(Iterable<Integer> ids) {
        return blogPostRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return blogPostRepository.count();
    }

    @Override
    public void deleteById(Integer id) {
        blogPostRepository.deleteById(id);
    }

    @Override
    public void delete(BlogPost blogPost) {
        blogPostRepository.delete(blogPost);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {
        blogPostRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends BlogPost> entities) {
        blogPostRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        blogPostRepository.deleteAll();
    }
}
