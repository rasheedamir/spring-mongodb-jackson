package io.as.mongodb.jackson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

@ComponentScan
@EnableAutoConfiguration
@Transactional
@SpringBootApplication
public class Application
{
    /**
     * Main method, used to run the application.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }
}
