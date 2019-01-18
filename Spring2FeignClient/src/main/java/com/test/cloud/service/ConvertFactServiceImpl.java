package com.test.cloud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.cloud.bean.ConversionFactor;

import com.test.cloud.repo.ConvertFactRepository;

@Service
public class ConvertFactServiceImpl implements ConvertFactService {

	@Autowired(required=true)
	private ConvertFactRepository  convertFactRepository;
	
	@Override
	public void addConversionFactor(ConversionFactor conversionFactor) {
	 
		 convertFactRepository.save(conversionFactor);
	}

	@Override
	public void updateConversionFactor(ConversionFactor conversionFactor) {
		 convertFactRepository.save(conversionFactor);
	}

	@Override
	public List<ConversionFactor> getConversionFactorList() {
	return	convertFactRepository.findAll();
		
	}

	public void setConvertFactRepository(ConvertFactRepository convertFactRepository) {
		this.convertFactRepository = convertFactRepository;
	}

	@Override
	public List<ConversionFactor> getbycontrycode(String contryCode) {
		// TODO Auto-generated method stub
		return convertFactRepository.getByContryCode(contryCode);
	}

	@Override
	public ConversionFactor getConversionfactById(Long id) {
		// TODO Auto-generated method stub
		
		 Optional<ConversionFactor> convertfact =convertFactRepository.findById(id);
		return convertfact.get();
	}

	 

}
