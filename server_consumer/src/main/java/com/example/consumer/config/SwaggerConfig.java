package com.example.consumer.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dlz
 * @date 2020/11/3
 * @description
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean(name = "server-consumer")
    public Docket createRestApi() {
        //添加头部参数
        ParameterBuilder p = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        p.name("Authorization").description("Authorization令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        // p2.name("userId").description("用户Id").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        // p3.name("userPhone").description("用户电话").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(p.build());
        // pars.add(p2.build());
        // pars.add(p3.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.consumer.controller"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars).groupName("server-consumer");
                // .pathMapping("/api/")
                // .select()
                // .apis(RequestHandlerSelectors.basePackage("com.example.consumer.controller"))
                // .paths(PathSelectors.any())
                // .build().apiInfo(new ApiInfoBuilder()
                //         .title("SpringBoot整合Swagger")
                //         .description("SpringBoot整合Swagger，详细信息......")
                //         .version("1.0")
                //         .contact(new Contact("", "", "dlz0729@126.com"))
                //         .license("The Apache License")
                //         .licenseUrl("")
                //         .build());
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("server-consumer接口文档")
                .description("接口文档-服务调用方")
                .termsOfServiceUrl("http://localhost:9001/server-consumer/doc.html")
                .contact(new Contact("","","dlz0729@126.com"))
                .version("1.0")
                .build();
    }
}
