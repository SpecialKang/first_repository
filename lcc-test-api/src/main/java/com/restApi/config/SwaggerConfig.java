package com.restApi.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

	@Bean
    public GroupedOpenApi getMemberApi() {

        return GroupedOpenApi
            .builder()
            .group("member")
            .pathsToMatch("/api/member/**")
          //.addOpenApiCustomiser(buildSecurityOpenApi())
            .build();

    }
	
	@Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Springdoc V3 테스트")
                .description("Springdoc V3 을 사용한 Swagger UI 테스트")
                .version("1.0.0");
    }
    
/*
    @Bean
    public GroupedOpenApi testApi() {
        return GroupedOpenApi.builder()
            .group("TEST-API")
            .packagesToScan("com.boki.realworld.api.test")
            .build();
    }

    @Bean
    public GroupedOpenApi nonTestApi() {
        return GroupedOpenApi.builder()
            .group("API")
            .packagesToExclude("com.boki.realworld.api.test")
            .build();
    }

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info().title("").version("1")
            .description("")
            .termsOfService("http://swagger.io/terms/")
            .contact(new Contact().name("boki").email("lsb530@naver.com"))
            .license(new License().name("").url(""));

        return new OpenAPI()
            .info(info)
            .components(new Components()
                .addSecuritySchemes("Authorization", new SecurityScheme()
                    .type(SecurityScheme.Type.APIKEY)
                    .in(SecurityScheme.In.HEADER)
                    .name("Authorization")))
            .addSecurityItem(new SecurityRequirement().addList("Authorization"));
    }
*/
	
}
 