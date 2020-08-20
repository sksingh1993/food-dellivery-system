package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration 
@EnableSwagger2 
public class SpringFoxConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .apiInfo(apiInfo())
          .select()
          .paths(Predicates.not(PathSelectors.regex("/error.*")))
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
    
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder()
    			.title("Food Dellivery System")
    			.description("Vender can register as well as add foods items and customer can search and order the foods")
    			.version("0.0.1")
    			.build();
    }
}
