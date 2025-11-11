package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class PromotionSwagger {
    @Bean
    public GroupedOpenApi PromotionApi() {
        return GroupedOpenApi.builder()
                .group("Promotion")
                .pathsToMatch("/api/Promotion/**")
                .build();
    }
    @Bean
    public OpenAPI PromotionOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Promotion API Documentation")
                        .description("Documentation des endpoints liés à la gestion des Promotions 🏠")
                        .version("1.0.0"));
    }
}
