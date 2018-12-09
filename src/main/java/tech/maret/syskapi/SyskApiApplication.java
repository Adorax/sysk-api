package tech.maret.syskapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication 
public class SyskApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SyskApiApplication.class, args);
	}
}
