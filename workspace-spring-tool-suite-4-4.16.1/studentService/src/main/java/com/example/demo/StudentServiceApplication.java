package com.example.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		
		//return a prepared docket instance
		return new Docket(DocumentationType.SWAGGER_2)
							.select()
							.paths(PathSelectors.ant("/**"))
							.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
							.build()
							.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo("Student Service Api",
							"Sample API", 
							"1.0", 
							"Free to use", 
							new Contact("ABC", "https://abc.com", "abc mail"),
							"API-licence"
							,"licence url for the app"
							,Collections.emptyList());
		
		
	}

}
