package com.valtech.base;

import com.valtech.domain.Car;
import com.valtech.repository.CarRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.stream.Stream;

@EnableJpaRepositories(basePackages = "com.valtech.repository")
@ComponentScan(basePackages = {"com.valtech"})
@EntityScan(basePackages = {"com.valtech.domain"})
@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class Application extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository carRepository) {
		return args -> {
			Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
			          "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
				Car car = new Car();
				car.setName(name);
				carRepository.save(car);
			});
			carRepository.findAll().forEach(System.out::println);
		};
	}
}
