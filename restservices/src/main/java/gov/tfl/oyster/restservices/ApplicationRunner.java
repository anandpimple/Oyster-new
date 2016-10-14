package gov.tfl.oyster.restservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by dev on 14/10/16.
 */
@SpringBootApplication
@ComponentScan
public class ApplicationRunner {
    public static void main(String [] args){
        ApplicationContext ctx = SpringApplication.run(ApplicationRunner.class, args);
    }
}
