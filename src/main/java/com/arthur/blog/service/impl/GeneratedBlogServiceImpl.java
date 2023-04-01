package com.arthur.blog.service.impl;

import com.arthur.blog.entity.generatedBlogPost.GeneratedBlogPost;
import com.arthur.blog.entity.generatedBlogPost.GeneratedBlogPostInput;
import com.arthur.blog.entity.generatedBlogPost.GeneratedBlogPostOutput;
import com.arthur.blog.service.GeneratedBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GeneratedBlogServiceImpl implements GeneratedBlogService {

    WebClient webClient;
    public final String token = "gAAAAABkDPtL7GCYfwU8LPaHXBs11AUR4tLj7Cl6UQi-hm_Ga9DPZG9Pehg-niZw06BvaU2auXBRLh-quWEJxk1C08OV4xf3OoR6FZ2w6fOlDAraINh4JEl4wyIbwsg61JNsAPs2hyq0";

    @Autowired
    public GeneratedBlogServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public GeneratedBlogPostOutput generateBlogPost(GeneratedBlogPostInput input) {
        GeneratedBlogPost response = webClient.post()
                .uri("/blogs")
                .headers(h -> h.setBearerAuth(token))
                .body(Mono.just(input), GeneratedBlogPostInput.class)
                .retrieve()
                .bodyToMono(GeneratedBlogPost.class)
                .block();
        assert response != null;
        return response.getData().getOutputs()[0];
    }
}
