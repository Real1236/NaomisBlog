package com.arthur.blog.controller;

import com.arthur.blog.entity.BlogPost;
import com.arthur.blog.entity.UserEntity;
import com.arthur.blog.entity.generatedBlogPost.GeneratedBlogPostInput;
import com.arthur.blog.entity.generatedBlogPost.GeneratedBlogPostOutput;
import com.arthur.blog.entity.generatedBlogPost.GeneratedBlogPostRequestBody;
import com.arthur.blog.service.*;
import com.arthur.blog.service.impl.GeneratedBlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
    GeneratedBlogService generatedBlogService;
    LikeService likeService;
    UserService userService;

    @Autowired
    public BlogController(BlogPostService blogPostService,
                          GeneratedBlogServiceImpl generatedBlogService,
                          LikeService likeService,
                          UserService userService) {
        this.blogPostService = blogPostService;
        this.generatedBlogService = generatedBlogService;
        this.likeService = likeService;
        this.userService = userService;
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
            originalBlogPost.ifPresent(post -> blogPost.setImage(post.getImage()));
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

    @GetMapping("/generate")
    public String generateBlogPostForm(Model model) {
        model.addAttribute("generatedBlogPostBody", new GeneratedBlogPostRequestBody());
        model.addAttribute("generatedBlogPost", null);
        return "/generate-blog-form";
    }

    @PostMapping("/generate")
    public String generateBlogPost(Model model, @ModelAttribute("generatedBlogPostBody") GeneratedBlogPostRequestBody input) {
        GeneratedBlogPostOutput output = generatedBlogService.generateBlogPost(
                new GeneratedBlogPostInput(input.getContext(), input.getKeywordsArray(), input.getTitle()));
        model.addAttribute("generatedBlogPostBody", input);
        model.addAttribute("generatedBlogPost", output);
        return "/generate-blog-form";
    }

    @PostMapping("/like/{id}")
    public String likePost(@PathVariable(name = "id") int blogPostId, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserEntity currentUser = userService.getUserByUsername(userDetails.getUsername());
        Optional<BlogPost> blogPost = blogPostService.findById(blogPostId);
        if (blogPost.isPresent()) {
            if (blogPost.get().getLikes().contains(currentUser)) {
                likeService.removeLike(currentUser.getId(), blogPostId);
            } else {
                likeService.addLike(currentUser.getId(), blogPostId);
            }
        } else {
            throw new RuntimeException("Blog post does not exist");
        }
        return "redirect:/blog/home";
    }

}
