package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class CarteFideliteSwagger {
    @Bean
    public GroupedOpenApi CarteFideliteApi() {
        return GroupedOpenApi.builder()
                .group("CarteFidelite")
                .pathsToMatch("/api/CarteFidelite/**")
                .build();
    }
    @Bean
    public OpenAPI CarteFideliteOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CarteFidelite API Documentation")
                        .description("Documentation des endpoints liés à la gestion des CarteFidelites 🏠")
                        .version("1.0.0"));
    }
}
