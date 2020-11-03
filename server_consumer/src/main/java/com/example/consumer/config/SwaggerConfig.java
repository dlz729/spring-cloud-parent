package com.example.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dlz
 * @date 2020/11/3
 * @description
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/api/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.consumer.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                .title("SpringBoot整合Swagger")
                .description("SpringBoot整合Swagger，详细信息......")
                .version("1.0")
                .contact(new Contact("","","dlz0729@126.com"))
                .license("The Apache License")
                .licenseUrl("")
                .build());
    }
}
