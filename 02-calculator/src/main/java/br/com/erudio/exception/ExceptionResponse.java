package br.com.erudio.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date timestump;
	private String messenge;
	private String details;
	
	public ExceptionResponse(Date timestump, String messenge, String details) {
		super();
		this.timestump = timestump;
		this.messenge = messenge;
		this.details = details;
	}

	public Date getTimestump() {
		return timestump;
	}

	public String getMessenge() {
		return messenge;
	}

	public String getDetails() {
		return details;
	}

}
