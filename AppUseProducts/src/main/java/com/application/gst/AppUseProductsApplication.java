package com.application.gst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AppUseProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppUseProductsApplication.class, args);
	}
	
    @Bean
    RestTemplate rest () {
	return new RestTemplate();
}
}
