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
	
}
 