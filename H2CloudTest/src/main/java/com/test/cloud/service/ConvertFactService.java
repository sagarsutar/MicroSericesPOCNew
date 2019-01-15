package com.test.cloud.service;

import java.util.List;

import com.test.cloud.bean.ConversionFactor;
import com.test.cloud.bean.StatusBean;

public interface ConvertFactService {

	    public void addConversionFactor(ConversionFactor conversionFactor) ;
		public void 	updateConversionFactor (ConversionFactor conversionFactor);
		public List<ConversionFactor>	getConversionFactorList ();
		public List<ConversionFactor>	getbycontrycode (String contryCode);
		
		public ConversionFactor getConversionfactById(Long id);
		 
}
