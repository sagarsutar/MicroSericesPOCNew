package com.test.feign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.feign.bean.ConversionFactor;

@FeignClient(name="currencyconvert-producer")
public interface CurrencyRemotCallService {
@GetMapping("/api/getbycontrycode")
public List<ConversionFactor>  getConversionFactor();
}
