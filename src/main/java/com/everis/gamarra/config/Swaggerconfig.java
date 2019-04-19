package com.everis.gamarra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class Swaggerconfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
						.select()
						.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
						.paths(PathSelectors.any())
						.build()
						.apiInfo(apiInfo());
	}

	/* http://localhost:8080/swagger-ui.html#/
	 *   Documentation
	 * */
	private ApiInfo apiInfo() {
		return new ApiInfo(
						"Spring boot RestfullApi",
						"BootCamp Trainee Everis 2019",
						"V 1.0.0",
						"Terms of controller",
						new Contact("Luis Alberto Gamarra Astocondor", "https://springboot.com",
										"luis.gam.94@gmail.com"), "License of Spring boot Restfull",
						"Spring boot license URL", Collections.emptyList());
	}
}
