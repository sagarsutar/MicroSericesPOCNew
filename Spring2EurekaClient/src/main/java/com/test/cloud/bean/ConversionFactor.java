package com.test.cloud.bean;



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

	
	 private Long id;
	 
	
	 private String contryCode;
	 
	
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
