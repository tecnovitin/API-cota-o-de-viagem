package com.example.demo.config;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch("/api/**")  // Ajuste para incluir apenas os caminhos que começam com /api/
                .packagesToScan("com.example.demo") // Ajuste para o pacote dos seus RestControllers
                .addOpenApiMethodFilter(method -> method.getDeclaringClass().isAnnotationPresent(RestController.class))
                .addOpenApiCustomizer(customOpenApi())
                .build();
    }

    public OpenApiCustomizer customOpenApi() {
        return openApi -> {
            openApi.getInfo().setTitle("ApiRestful"); // Renomeia o título
            openApi.getInfo().setVersion("1.0.1"); // Define a versão
            openApi.getInfo().setDescription("API Sistema de Cotação de Viagem"); // Define a descrição
        };
    }
}
