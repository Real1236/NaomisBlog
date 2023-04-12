package com.arthur.blog.entity.generatedBlogPost;

public class GeneratedBlogPostRequestBody {
    private String context;
    private String keywords;
    private String title;

    public GeneratedBlogPostRequestBody() {
    }

    public GeneratedBlogPostRequestBody(String context, String keywords, String title) {
        this.context = context;
        this.keywords = keywords;
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getKeywordsArray() {
        String temp = this.keywords.replaceAll("\\s*,\\s*", ",");
        return temp.split(",");
    }
}
