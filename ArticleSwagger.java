package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleSwagger {

    @Bean
    public GroupedOpenApi ArticleApi() {
        return GroupedOpenApi.builder()
                .group("Article")
                .pathsToMatch("/api/Article/**")
                .build();
    }

}

