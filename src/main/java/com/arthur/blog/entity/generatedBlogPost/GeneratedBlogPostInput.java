package com.arthur.blog.entity.generatedBlogPost;

public class GeneratedBlogPostInput {

    private String context;
    private String[] keywords;
    private int max_tokens;
    private int n;
    private String source_lang;
    private String target_lang;
    private double temperature;
    private String title;

    public GeneratedBlogPostInput() {
    }

    public GeneratedBlogPostInput(String context, String[] keywords, String title) {
        this.context = context;
        this.keywords = keywords;
        this.max_tokens = 256;
        this.n = 1;
        this.source_lang = "en";
        this.target_lang = "en";
        this.temperature = 0.65;
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(int max_tokens) {
        this.max_tokens = max_tokens;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getSource_lang() {
        return source_lang;
    }

    public void setSource_lang(String source_lang) {
        this.source_lang = source_lang;
    }

    public String getTarget_lang() {
        return target_lang;
    }

    public void setTarget_lang(String target_lang) {
        this.target_lang = target_lang;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
