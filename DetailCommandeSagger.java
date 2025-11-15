package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DetailCommandeSagger {
    @Bean
    public GroupedOpenApi DetailCommandeApi() {
        return GroupedOpenApi.builder()
                .group("DetailCommande")
                .pathsToMatch("/api/DetailCommande/**")
                .build();
    }
}
