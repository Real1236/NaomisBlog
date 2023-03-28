package com.arthur.blog.service;

import com.arthur.blog.entity.generatedBlogPost.GeneratedBlogPostInput;
import com.arthur.blog.entity.generatedBlogPost.GeneratedBlogPostOutput;

public interface GeneratedBlogService {

    GeneratedBlogPostOutput generateBlogPost(GeneratedBlogPostInput input);

}
