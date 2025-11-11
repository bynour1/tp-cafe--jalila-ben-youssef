package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class ArticleSwagger {

    @Bean
    public GroupedOpenApi ArticleApi() {
        return GroupedOpenApi.builder()
                .group("Article")
                .pathsToMatch("/api/Article/**")
                .build();
    }
    @Bean
    public OpenAPI ArticleOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Article API Documentation")
                        .description("Documentation des endpoints liés à la gestion des Articles 🏠")
                        .version("1.0.0"));
    }
}

