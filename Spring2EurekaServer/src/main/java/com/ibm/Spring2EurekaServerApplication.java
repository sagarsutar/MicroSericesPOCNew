package com.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Spring2EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring2EurekaServerApplication.class, args);
	}

}

