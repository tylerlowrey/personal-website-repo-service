package com.tylerlowrey.personalwebsitereposervice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.tylerlowrey.personalwebsitereposervice"})
public class PersonalWebsiteRepoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalWebsiteRepoServiceApplication.class, args);
	}

}
