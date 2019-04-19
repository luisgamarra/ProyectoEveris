package com.everis.gamarra.utility.exceptions;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ErrorMessage {
	private Date timestamp;
	private String message;
	private List<String> details;
	//private int status;

	public ErrorMessage(){}

	public ErrorMessage(Date timestamp, String message,List<String> details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		//this.status  = status;
	}
}
