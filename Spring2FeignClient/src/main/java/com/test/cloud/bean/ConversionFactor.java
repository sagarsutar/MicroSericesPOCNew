package com.test.cloud.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONVERSIONFACTOR")
public class ConversionFactor {
	public ConversionFactor() {
		// TODO Auto-generated constructor stub
	}
	 public ConversionFactor(Long id, String contryCode, Double convertFact) {
		super();
		this.id = id;
		this.contryCode = contryCode;
		this.convertFact = convertFact;
	}

	@Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name="CONTRY_CODE")
	 private String contryCode;
	 
	 @Column(name="CONVERT_FACT")
	 private Double convertFact;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContryCode() {
		return contryCode;
	}

	public void setContryCode(String contryCode) {
		this.contryCode = contryCode;
	}

	public Double getConvertFact() {
		return convertFact;
	}

	public void setConvertFact(Double convertFact) {
		this.convertFact = convertFact;
	}

	@Override
	public String toString() {
		return "ConversionFactor [id=" + id + ", contryCode=" + contryCode + ", convertFact=" + convertFact + "]";
	}
	 

}
