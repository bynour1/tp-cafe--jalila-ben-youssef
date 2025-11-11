package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class ClientSwagger {
    @Bean
    public GroupedOpenApi ClientApi() {
        return GroupedOpenApi.builder()
                .group("Client")
                .pathsToMatch("/api/Client/**")
                .build();
    }
    @Bean
    public OpenAPI ClientOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Client API Documentation")
                        .description("Documentation des endpoints liés à la gestion des Clients 🏠")
                        .version("1.0.0"));
    }
}
