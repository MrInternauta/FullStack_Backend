package com.mrinternauta.RestApi.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*", "http://localhost:4200", "localhost:4200", "localhost", "http://localhost")
                .allowedMethods("*","GET", "DELETE", "POST", "POST", "OPTIONS")
                .allowedHeaders("User-Agent",  "sec-ch-ua-mobile","sec-ch-ua","Referer", "Access-Control-Allow-Headers", "Access-Control-Allow-Origin", "*", "authorization","Authorization", "Content-Type", "Accept", "Accept-Language", "Content-Language")
                .exposedHeaders("User-Agent",  "sec-ch-ua-mobile","sec-ch-ua","Referer", "Access-Control-Allow-Headers", "Access-Control-Allow-Origin", "*", "authorization","Authorization", "Content-Type", "Accept", "Accept-Language", "Content-Language")
                .allowCredentials(true).maxAge(3600);
    }
}