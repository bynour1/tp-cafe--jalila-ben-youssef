package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class CommandeSwagger {
    @Bean
    public GroupedOpenApi CommandeApi() {
        return GroupedOpenApi.builder()
                .group("Commande")
                .pathsToMatch("/api/Commande/**")
                .build();
    }
    @Bean
    public OpenAPI CommandeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Commande API Documentation")
                        .description("Documentation des endpoints liés à la gestion des Commandes 🏠")
                        .version("1.0.0"));
    }
}
