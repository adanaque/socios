package com.cine.socios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SociosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SociosApplication.class, args);
	}

}
