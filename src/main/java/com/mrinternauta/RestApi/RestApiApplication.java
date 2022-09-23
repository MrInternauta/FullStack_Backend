package com.mrinternauta.RestApi;

import com.mrinternauta.RestApi.web.config.RestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestApiApplication  implements CommandLineRunner {
	@Autowired
	RestConfig restConfig;

	@Override
	public void run(String... args) throws Exception {
	}


	//Project was focused at domain
	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
