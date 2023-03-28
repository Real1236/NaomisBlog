package com.arthur.blog.entity.generatedBlogPost;

public class GeneratedBlogPost {

    private String status;

    private GeneratedBlogPostData data;

    public GeneratedBlogPost() {
    }

    public GeneratedBlogPost(String status, GeneratedBlogPostData data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GeneratedBlogPostData getData() {
        return data;
    }

    public void setData(GeneratedBlogPostData data) {
        this.data = data;
    }
}
