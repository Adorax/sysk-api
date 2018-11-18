package tech.maret.syskapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "tech.maret.syskapi.domain")
@SpringBootApplication 
public class SyskApiApplication {//extends SpringBootServletInitializer {
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SyskApiApplication.class);
	}
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
*/
	public static void main(String[] args) {
		SpringApplication.run(SyskApiApplication.class, args);
	}
}
