package tech.maret.syskapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "tech.maret.syskapi.domain") 
public class SyskApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyskApiApplication.class, args);
	}
}
