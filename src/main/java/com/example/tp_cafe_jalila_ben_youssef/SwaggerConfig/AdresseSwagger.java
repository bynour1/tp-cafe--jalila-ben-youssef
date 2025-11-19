package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdresseSwagger {
    @Bean
    public GroupedOpenApi adresseApi() {
        return GroupedOpenApi.builder()
                .group("Adresse")
                .pathsToMatch("/api/adresse/**")
                .build();
    }


}
