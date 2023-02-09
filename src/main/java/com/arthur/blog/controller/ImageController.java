package com.arthur.blog.controller;

import com.arthur.blog.entity.BlogPost;
import com.arthur.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/image")
public class ImageController {

    BlogPostService blogPostService;

    @Autowired
    public ImageController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        Optional<BlogPost> blogPost = blogPostService.findById(id);
        assert blogPost.orElse(null) != null;
        byte[] image = blogPost.orElse(null).getImage();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteImage(@PathVariable("id") int id) {
        Optional<BlogPost> blogPost = blogPostService.findById(id);
        assert blogPost.orElse(null) != null;
        blogPostService.deleteImage(blogPost.get());
        return "redirect:/blog/blogPost/" + id;
    }
}
