package com.evolvice.cars.api.startapp;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.evolvice.cars.api.authentication.AuthenticateAPI;
import com.evolvice.cars.api.controller.CarsController;
import com.evolvice.cars.api.repository.CarsRepository;


/**
 * App Class is the SpringBoot Loader
 *
 */
@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = CarsRepository.class)
@ComponentScan(basePackageClasses = {CarsController.class, AuthenticateAPI.class})
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("Cars API Started................");
	}
}
