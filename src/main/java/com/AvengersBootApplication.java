package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@EnableWebMvc
@SpringBootApplication
public class AvengersBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvengersBootApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("Avengers Api") String appDesciption, @Value("1.0") String appVersion) {

		return new OpenAPI()

				.info(new Info()

						.title("Avengers API")

						.version(appVersion)

						.description(appDesciption)

						.termsOfService("http://swagger.io/terms/")

						.license(new License().name("Apache 2.0").url("http://springdoc.org")));

	}
}
