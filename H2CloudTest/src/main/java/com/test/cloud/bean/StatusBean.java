package com.test.cloud.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class StatusBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonInclude(value=Include.NON_NULL)
	private String status;
	@JsonInclude(value=Include.NON_NULL)
	private String error;
	@JsonInclude(value=Include.NON_NULL)
	private Double amount;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
