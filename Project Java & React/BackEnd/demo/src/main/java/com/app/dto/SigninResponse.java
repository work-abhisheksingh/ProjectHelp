package com.app.dto;

public class SigninResponse {

	private String name;

	public SigninResponse() {

	}

	public SigninResponse(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SigninDto [name=" + name + "]";
	}
	
	

}
