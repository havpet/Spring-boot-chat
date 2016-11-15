package com.hib;

import com.hib.controllers.UserController;
import com.hib.entities.User;
import com.hib.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Mod250ProjectPrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mod250ProjectPrototypeApplication.class, args);
	}

}
