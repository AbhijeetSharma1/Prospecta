package com.prospecta.exceptions;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
public class GlobalExceptionHandler {
	@ExceptionHandler(InvalidEntryException.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(InvalidEntryException se, WebRequest req){
	MyErrorDetails error= new MyErrorDetails();
			error.setTimestamp(LocalDateTime.now());
			error.setMessage(se.getMessage());
			error.setDetails(req.getDescription(false));	
		return new ResponseEntity<MyErrorDetails>(error, HttpStatus.NOT_FOUND);		
	}
}
