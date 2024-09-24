package com.corporate.corporateApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CorporateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorporateApplication.class, args);
	}
}
