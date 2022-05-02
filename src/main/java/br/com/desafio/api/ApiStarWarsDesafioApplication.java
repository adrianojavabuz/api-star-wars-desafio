package br.com.desafio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;


@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = {"br.com.desafio.api"})
@EnableAutoConfiguration
public class ApiStarWarsDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiStarWarsDesafioApplication.class, args);
	}

	/**
	 * Configuração das propriedades de desserialização JSON do Jackson Provider.
	 *
	 * @return Jackson2ObjectMapperBuilderCustomizer
	 */
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {

		return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
	}

	/**
	 * Configuração das propriedades das requisições REST
	 *
	 * @param restTemplateBuilder
	 * @return RestTemplate
	 */
}
