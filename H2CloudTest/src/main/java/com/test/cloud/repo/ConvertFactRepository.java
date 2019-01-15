package com.test.cloud.repo;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.cloud.bean.ConversionFactor;

@Repository
public interface ConvertFactRepository extends JpaRepository<ConversionFactor,Long>{

	List<ConversionFactor> getByContryCode(String contryCode);
}
