package com.springcloud.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@ConfigurationProperties
public class EurekaServerEntryPoint {
	
	@Value("${welcome.message}")
	private static String message;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		SpringApplication.run(EurekaServerEntryPoint.class, args);
		System.out.println("################################################");
		System.out.println(message);
		
	}

}
