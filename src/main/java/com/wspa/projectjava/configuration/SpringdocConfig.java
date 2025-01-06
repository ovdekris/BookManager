package com.wspa.projectjava.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SpringdocConfig {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Doc")
                        .version("1.0.0")
                        .description("Springdoc Global API Responses Example"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addResponses("defaultBadRequest", getBadRequestResponse())
                        .addResponses("defaultUnauthorized", getUnauthorizedResponse())
                        .addResponses("defaultForbidden", getForbiddenResponse())
                        .addResponses("defaultInternalServerError", getInternalServerErrorResponse()));
    }

    private io.swagger.v3.oas.models.responses.ApiResponse getBadRequestResponse() {
        return new io.swagger.v3.oas.models.responses.ApiResponse()
                .description("Bad Request")
                .content(new Content().addMediaType("application/json", new io.swagger.v3.oas.models.media.MediaType()
                        .addExamples("default", new io.swagger.v3.oas.models.examples.Example().value("{\"code\": 400, \"status\": \"Bad Request\", \"message\": \"Invalid input\"}"))));
    }

    private io.swagger.v3.oas.models.responses.ApiResponse getUnauthorizedResponse() {
        return new io.swagger.v3.oas.models.responses.ApiResponse()
                .description("Unauthorized")
                .content(new Content().addMediaType("application/json", new io.swagger.v3.oas.models.media.MediaType()
                        .addExamples("default", new io.swagger.v3.oas.models.examples.Example().value("{\"code\": 401, \"status\": \"Unauthorized\", \"message\": \"Authentication failed\"}"))));
    }

    private io.swagger.v3.oas.models.responses.ApiResponse getForbiddenResponse() {
        return new io.swagger.v3.oas.models.responses.ApiResponse()
                .description("Forbidden")
                .content(new Content().addMediaType("application/json", new io.swagger.v3.oas.models.media.MediaType()
                        .addExamples("default", new io.swagger.v3.oas.models.examples.Example().value("{\"code\": 403, \"status\": \"Forbidden\", \"message\": \"Access denied\"}"))));
    }

    private io.swagger.v3.oas.models.responses.ApiResponse getInternalServerErrorResponse() {
        return new io.swagger.v3.oas.models.responses.ApiResponse()
                .description("Internal Server Error")
                .content(new Content().addMediaType("application/json", new io.swagger.v3.oas.models.media.MediaType()
                        .addExamples("default", new io.swagger.v3.oas.models.examples.Example().value("{\"code\": 500, \"status\": \"Internal Server Error\", \"message\": \"Unexpected error occurred\"}"))));
    }
}