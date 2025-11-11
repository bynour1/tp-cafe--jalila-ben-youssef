package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class DetailCommandeSagger {
    @Bean
    public GroupedOpenApi DetailCommandeApi() {
        return GroupedOpenApi.builder()
                .group("DetailCommande")
                .pathsToMatch("/api/DetailCommande/**")
                .build();
    }
    @Bean
    public OpenAPI DetailCommandeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DetailCommande API Documentation")
                        .description("Documentation des endpoints liés à la gestion des DetailCommandes 🏠")
                        .version("1.0.0"));
    }
}
