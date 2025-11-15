package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarteFideliteSwagger {
    @Bean
    public GroupedOpenApi CarteFideliteApi() {
        return GroupedOpenApi.builder()
                .group("CarteFidelite")
                .pathsToMatch("/api/CarteFidelite/**")
                .build();
    }

}
