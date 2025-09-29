package com.DBank.DBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBankApplication.class, args);
	}

}
