package com.proyecto.creditosinvested.models;

import java.util.ArrayList;

public class WebServiceResponse {
	private boolean success;
	private ArrayList <Object> results;
	private String errorMessage;

	public WebServiceResponse(boolean success, String errorMessage) {
		this.success = success;
		this.errorMessage = errorMessage;
		this.results = new ArrayList<Object>();
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ArrayList<Object> getResults() {
		return results;
	}

	public void setResults(ArrayList<Object> results) {
		this.results = results;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void addResult(Object result) {
		this.results.add(result);
	}
}
