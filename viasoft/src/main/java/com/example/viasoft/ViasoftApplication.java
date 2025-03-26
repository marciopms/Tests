package com.example.viasoft;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Envio de E-mail", description = "API de testes | viasoft"))
public class ViasoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViasoftApplication.class, args);
	}

}
