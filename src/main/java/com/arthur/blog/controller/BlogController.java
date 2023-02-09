package com.arthur.blog.controller;

import com.arthur.blog.entity.BlogPost;
import com.arthur.blog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Date;
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
    public String saveBlogPost(@RequestParam("id") int id,
                               @RequestParam("title") String title,
                               @RequestParam("date") Date date,
                               @RequestParam("image") MultipartFile image,
                               @RequestParam("blog") String blog) throws IOException {
        Optional<BlogPost> blogPost = blogPostService.findById(id);
        if (blogPost.orElse(null) == null) {
            blogPostService.save(new BlogPost(title, date, image.getBytes(), blog));
        } else {
            blogPost.get().setTitle(title);
            blogPost.get().setDate(date);
            blogPost.get().setImage(image.getBytes());
            blogPost.get().setBlog(blog);
            blogPostService.save(blogPost.get());
        }
        return "redirect:/blog/home";
    }

    @DeleteMapping("/blogPost/{id}")
    public String deleteBlogPost(@PathVariable("id") int id) {
        blogPostService.deleteById(id);
        return "redirect:/blog/home";
    }

}
