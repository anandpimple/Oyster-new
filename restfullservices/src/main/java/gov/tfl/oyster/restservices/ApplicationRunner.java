package gov.tfl.oyster.restservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by dev on 14/10/16.
 */
@SpringBootApplication
public class ApplicationRunner {
    public static void main(String [] args){

        ApplicationContext ctx = SpringApplication.run(ApplicationRunner.class, args);
    }
}
