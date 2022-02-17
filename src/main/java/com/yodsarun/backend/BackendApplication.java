package com.yodsarun.backend;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import com.yodsarun.backend.modal.Users;
import com.yodsarun.backend.repository.UserRepository;

@SpringBootApplication
@EnableCaching
public class BackendApplication {
	private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		log.info("BackendApplication has been start successfully.");
	}

	// init Customer
//	@Bean
//	public CommandLineRunner demo(UserRepository repository) {
//		return (args) -> {
//			// save a few customers
//			repository.save(new Users(1, "Jack", "Bauer"));
//			repository.save(new Users(2, "Chloe", "O'Brian"));
//			repository.save(new Users(3, "Kim", "Bauer"));
//			repository.save(new Users(4, "David", "Palmer"));
//			repository.save(new Users(5, "Michelle", "Dessler"));
//
//			// fetch all Users
//			log.info("Userss found with findAll():");
//			log.info("-------------------------------");
//			for (Users users : repository.findAll()) {
//				log.info(users.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			Optional<Users> customer = repository.findById(1L);
//			log.info("Customer found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			//  log.info(bauer.toString());
//			// }
//			log.info("");
//		};
//	}
}
