package com.ibm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.test.cloud.bean.ConversionFactor;

public interface CurrConvertController {
	@PostMapping("/api/addconvertfact")
	 public void addConversionFactor(ConversionFactor conversionFactor) ;
	@PutMapping("/api/updateconvertfact/{id}")
		public void 	updateConversionFactor (ConversionFactor conversionFactor);
	@GetMapping("/api/getconvertfactlist")
		public List<ConversionFactor>	getConversionFactorList ();
		@PostMapping("/api/getbycontrycode")
		public List<ConversionFactor>	getbycontrycode (String contryCode);
		public ConversionFactor getConversionfactById(Long id);
}
