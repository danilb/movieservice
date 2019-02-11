package com.lt.movieservice;

import com.lt.movieservice.model.Title;
import com.lt.movieservice.model.TitleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieserviceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TitleRepository repo) {
		return (args) ->{
			repo.save(new Title().setTitleId("Test"));
		};
	}

}

