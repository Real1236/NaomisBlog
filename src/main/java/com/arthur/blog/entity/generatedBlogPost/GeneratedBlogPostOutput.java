package com.arthur.blog.entity.generatedBlogPost;

public class GeneratedBlogPostOutput {

    private int index;

    private String text;

    private String id;

    public GeneratedBlogPostOutput() {
    }

    public GeneratedBlogPostOutput(int index, String text, String id) {
        this.index = index;
        this.text = text;
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
