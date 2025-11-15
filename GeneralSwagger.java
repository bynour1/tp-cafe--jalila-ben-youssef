package com.example.tp_cafe_jalila_ben_youssef.SwaggerConfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class GeneralSwagger {

    @Bean
    @Primary
    public OpenAPI globalOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TPCafe API - Système Complet")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Équipe TPCafe")
                                .email("support@tpcafe.com")
                                .url("https://tpcafe.com")))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8083")
                                .description("Serveur de développement"),
                        new Server()
                                .url("https://api.tpcafe.com")
                                .description("Serveur de production")
                ));}}