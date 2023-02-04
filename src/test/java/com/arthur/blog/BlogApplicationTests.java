package com.arthur.blog;

import com.arthur.blog.entity.BlogPost;
import com.arthur.blog.service.BlogPostService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
class BlogApplicationTests {

	@Autowired
	BlogPostService blogPostService;

	@Test
	void getBlogPosts() {
		Iterable<BlogPost> blogPosts = blogPostService.findAll();
		Assertions.assertThat(blogPosts).isNotEmpty();
	}

	@Test
	void saveBlogPost() {
		BlogPost newBlogPost = new BlogPost();
		newBlogPost.setTitle("Why does hospital toast taste so good?");
		newBlogPost.setDate(Date.valueOf("2023-01-26"));
		newBlogPost.setBlog("Toast goes yum");

		BlogPost savedBlogPost = blogPostService.save(newBlogPost);

		Assertions.assertThat(savedBlogPost).isNotNull();
	}

}
