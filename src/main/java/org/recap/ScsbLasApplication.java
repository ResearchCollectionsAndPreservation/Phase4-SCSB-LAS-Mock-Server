package org.recap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@SpringBootApplication
public class ScsbLasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScsbLasApplication.class, args);
	}

}
