package com.app.dto;

import java.time.LocalDateTime;

public class DeleteResponse {
	private LocalDateTime timestamp;
	private String message;
	public DeleteResponse(String message) {
		super();
		this.message = message;
		this.timestamp=LocalDateTime.now();
	}
	public DeleteResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
