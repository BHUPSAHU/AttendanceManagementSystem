package com.ams.exception;

import java.time.LocalDateTime;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> recordNotFoundException(RecordNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"RecordNotFoundException : \n"+ ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	
	
	@ExceptionHandler(ConstraintViolationException.class) 
	  public ResponseEntity<?> validationExceptionHandler(ConstraintViolationException ex, WebRequest request) {
		 ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"\n ConstraintViolationException :"+ ex.getMessage() ,request.getDescription(false)); 
		 return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	@ExceptionHandler(Exception.class) 
	  public ResponseEntity<?> globalExcpetionHandler(Exception ex, WebRequest request) {
		 ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),"Exception \n: "+ ex.getMessage() ,request.getDescription(false)); 
		 return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}