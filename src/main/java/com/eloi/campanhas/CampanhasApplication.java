package com.eloi.campanhas;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
		basePackageClasses = {CampanhasApplication.class, Jsr310JpaConverters.class}
)
@SpringBootApplication
public class CampanhasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampanhasApplication.class, args);
	}
	
	public static final DateTimeFormatter FORMATTER = ofPattern("dd::MM::yyyy");

//    @Bean
//    @Primary
//    public ObjectMapper serializingObjectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        JavaTimeModule javaTimeModule = new JavaTimeModule();
//        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
//        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
//        objectMapper.registerModule(javaTimeModule);
//        return objectMapper;
//    }

}
