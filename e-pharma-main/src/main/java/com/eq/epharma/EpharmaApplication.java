package com.eq.epharma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class EpharmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpharmaApplication.class, args);
	}

}
