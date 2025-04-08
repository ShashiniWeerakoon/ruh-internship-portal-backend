package ruh_internship_portal_backend.example.ruh_internship_portal_backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RuhInternshipPortalBackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(RuhInternshipPortalBackendApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule()); // Enable Java 8 date/time support
		return mapper;
	}
}