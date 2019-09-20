package com.dbserver.desafioRastaurante.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private final ResponseMessage m201 = simpleMessage(201, "Recurso criado");
	private final ResponseMessage m400 = simpleMessage(400, "Erro de validação");
	private final ResponseMessage m404 = simpleMessage(404, "Não encontrado");
	private final ResponseMessage m500 = simpleMessage(500, "Erro inesperado");
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.POST, Arrays.asList(m201, m400,m404, m500))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.dbserver.desafioRastaurante.resource"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("API Desafio - Votação Restaurante", "Essa API é utilizada para fins didáticos",
				"Verssão 1.0", null,
				new Contact("Guilherme Palma", "linkedin.com/in/guilherme-palm4", "gomes.lmc@gmail.com"), null, null,
				Collections.emptyList());
	}

	private ResponseMessage simpleMessage(int code, String msg) {
		return new ResponseMessageBuilder().code(code).message(msg).build();
	}
}
