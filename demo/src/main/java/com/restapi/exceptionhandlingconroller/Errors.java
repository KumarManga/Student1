package com.restapi.exceptionhandlingconroller;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Errors {
	
	private String message;
	private String timeStamp;
	private String error;
	private HttpStatus statusCode;

}
