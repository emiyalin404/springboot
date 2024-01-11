package net.javaguides;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class SpringbootSearchRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSearchRestApiApplication.class, args);
	}

}
