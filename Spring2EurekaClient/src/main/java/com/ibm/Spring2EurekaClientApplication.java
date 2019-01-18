package com.ibm;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.controller.CurrConvertController;
import com.ibm.controller.GreetingController;
import com.netflix.discovery.EurekaClient;
import com.test.cloud.bean.ConversionFactor;
import com.test.cloud.repo.ConvertFactRepository;
import com.test.cloud.service.ConvertFactService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication 
@EnableSwagger2
@EnableDiscoveryClient
@Component
@RestController
public class Spring2EurekaClientApplication implements GreetingController,ConvertFactService {
	@Autowired
    @Lazy
    private EurekaClient eurekaClient;
 
    @Value("${spring.application.name}")
    private String appName;
    
    @Autowired(required=true)
	private ConvertFactService convertFactService;
	
	public static void main(String[] args) {
		SpringApplication.run(Spring2EurekaClientApplication.class, args);
	}

	@Override
	public String greeting() {
		// TODO Auto-generated method stub
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	}

	@Override
	public void addConversionFactor(ConversionFactor conversionFactor) {
	 
		convertFactService.addConversionFactor(conversionFactor) ;
	}

	@Override
	public void updateConversionFactor(ConversionFactor conversionFactor) {
		convertFactService.updateConversionFactor(conversionFactor);;
	}

	@Override
	public List<ConversionFactor> getConversionFactorList() {
	return	convertFactService.getConversionFactorList();
		
	}

	 
	@Override
	public List<ConversionFactor> getbycontrycode(String contryCode) {
		// TODO Auto-generated method stub
		return convertFactService.getbycontrycode(contryCode);
	}

	@Override
	public ConversionFactor getConversionfactById(Long id) {
		// TODO Auto-generated method stub
		
		  
		return convertFactService.getConversionfactById(id);
	}

	public void setConvertFactService(ConvertFactService convertFactService) {
		this.convertFactService = convertFactService;
	}
}

