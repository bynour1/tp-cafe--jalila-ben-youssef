package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandeSwagger {
    @Bean
    public GroupedOpenApi CommandeApi() {
        return GroupedOpenApi.builder()
                .group("Commande")
                .pathsToMatch("/api/Commande/**")
                .build();
    }

}
