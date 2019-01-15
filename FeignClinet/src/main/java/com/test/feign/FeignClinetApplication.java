package com.test.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.test.feign.controller.CurrencyConvrtControllerClient;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class FeignClinetApplication {

	public static void main(String[] args)   {
		SpringApplication.run(FeignClinetApplication.class, args);
		/*CurrencyConvrtControllerClient currencyConvrtControllerClient=ctx.getBean(CurrencyConvrtControllerClient.class);
		try {
			currencyConvrtControllerClient.getConvertFactList();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Bean
	   public RestTemplate restTemplate(RestTemplateBuilder builder) {
	      return builder.build();
	   }
}

