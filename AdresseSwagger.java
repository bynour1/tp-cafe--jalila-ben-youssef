package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
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


    @Bean
    public OpenAPI adresseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Adresse API Documentation")
                        .description("Documentation des endpoints liés à la gestion des adresses 🏠")
                        .version("1.0.0"));
    }
}
