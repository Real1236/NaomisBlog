package com.arthur.blog.entity.generatedBlogPost;

public class GeneratedBlogPostData {

    private GeneratedBlogPostOutput[] outputs;

    private int remaining_credits;

    public GeneratedBlogPostData() {
    }

    public GeneratedBlogPostData(GeneratedBlogPostOutput[] outputs, int remaining_credits) {
        this.outputs = outputs;
        this.remaining_credits = remaining_credits;
    }

    public GeneratedBlogPostOutput[] getOutputs() {
        return outputs;
    }

    public void setOutputs(GeneratedBlogPostOutput[] outputs) {
        this.outputs = outputs;
    }

    public int getRemaining_credits() {
        return remaining_credits;
    }

    public void setRemaining_credits(int remaining_credits) {
        this.remaining_credits = remaining_credits;
    }
}
