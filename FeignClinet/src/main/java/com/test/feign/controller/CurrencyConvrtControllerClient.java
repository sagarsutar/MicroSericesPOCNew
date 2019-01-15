package com.test.feign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.test.feign.bean.ConversionFactor;
import com.test.feign.service.CurrencyRemotCallService;


@RefreshScope
@RestController
public class CurrencyConvrtControllerClient {

	@Autowired
	CurrencyRemotCallService currencyRemotCallService;
	public void getConvertFactList() throws Exception{
		try {
		List<ConversionFactor> convrList=currencyRemotCallService.getConversionFactor();
		
		 for(ConversionFactor confact:convrList) {
			 System.out.println("getContryCode "+confact.getContryCode());
			 System.out.println("getConvertFact "+confact.getConvertFact());
			 System.out.println("getId "+confact.getId());
		 }
		 
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
