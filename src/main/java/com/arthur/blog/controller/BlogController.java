package com.arthur.blog.controller;

import com.arthur.blog.entity.BlogPost;
import com.arthur.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {

    BlogPostService blogPostService;

    @Autowired
    public BlogController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("blogPosts", blogPostService.findAll());
        return "home";
    }

    @GetMapping("/blogPost")
    public String blogPostForm(Model model) {
        model.addAttribute("newBlogPost", new BlogPost());
        return "blogpost-form";
    }

    @GetMapping("/blogPost/{id}")
    public String blogPostForm(Model model, @PathVariable("id") int id) {
        Optional<BlogPost> blogPost = blogPostService.findById(id);
        if (blogPost.isEmpty()) {
            throw new RuntimeException("Blog post does not exist");
        }
        model.addAttribute("newBlogPost", blogPost.get());
        return "blogpost-form";
    }

    @PostMapping("/blogPost")
    public String saveBlogPost(@ModelAttribute("newBlogPost") BlogPost blogPost,
                               @RequestParam("imageFile") MultipartFile image) throws IOException {
        if (image == null || image.isEmpty()) {
            Optional<BlogPost> originalBlogPost = blogPostService.findById(blogPost.getId());
            assert originalBlogPost.orElse(null) != null;
            blogPost.setImage(originalBlogPost.get().getImage());
        } else {
            blogPost.setImage(image.getBytes());
        }
        blogPostService.save(blogPost);
        return "redirect:/blog/home";
    }

    @DeleteMapping("/blogPost/{id}")
    public String deleteBlogPost(@PathVariable("id") int id) {
        blogPostService.deleteById(id);
        return "redirect:/blog/home";
    }

}
