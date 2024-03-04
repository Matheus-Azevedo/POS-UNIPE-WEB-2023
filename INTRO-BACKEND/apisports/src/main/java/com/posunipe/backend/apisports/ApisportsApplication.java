package com.posunipe.backend.apisports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApisportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApisportsApplication.class, args);
	}

}
