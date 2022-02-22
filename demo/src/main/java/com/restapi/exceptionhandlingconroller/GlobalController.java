package com.restapi.exceptionhandlingconroller;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalController {
	
	@ExceptionHandler(StudentResourceNotFoundException.class)
	public ResponseEntity<?> handleStudentResourceNotFoundException(StudentResourceNotFoundException exception,
			WebRequest request) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis()); 
		 String str=timestamp.toString();  
		Errors details = new Errors(exception.getMessage(), str ,request.getDescription(false),HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

}
