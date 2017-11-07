package com.eloi.campanhas;

import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.eloi.campanhas.infrastructure.LocalDateDeserializer;
import com.eloi.campanhas.infrastructure.LocalDateSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;

@SpringBootApplication
public class CampanhasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampanhasApplication.class, args);
	}
	
	public static final DateTimeFormatter FORMATTER = ofPattern("dd::MM::yyyy");

    @Bean
    @Primary
    public ObjectMapper serializingObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        objectMapper.registerModule(javaTimeModule);
        return objectMapper;
    }

}
