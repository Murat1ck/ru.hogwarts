package ru.hogwarts.school;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@OpenAPIDefinition
@SpringBootApplication
//@ComponentScan("application")
//@EnableJpaRepositories("healthchecker")
//@EntityScan("healthchecker")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
