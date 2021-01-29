package org.recap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@SpringBootApplication
public class RecapLasApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecapLasApplication.class, args);
    }

}
