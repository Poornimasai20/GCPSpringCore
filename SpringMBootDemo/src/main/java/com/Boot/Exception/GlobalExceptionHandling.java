package com.Boot.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler{
	
	
	  @ExceptionHandler(IdNotFoundException.class) public
	  ResponseEntity<BookIdExceptionDetails>
	  idNotFoundException(IdNotFoundException ex) { BookIdExceptionDetails
	  response= new BookIdExceptionDetails(); response.setErrorcode("NOT FOUND");
	  response.setErrormsg(ex.getMessage());
	  response.setTimestamp(LocalDateTime.now());
	  
	  return new
	  ResponseEntity<BookIdExceptionDetails>(response,HttpStatus.NOT_FOUND); }
	 
	
	

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status,WebRequest request)
	{
	
		Map <String, String> errors =new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldname =((FieldError) error).getField();
			String message=error.getDefaultMessage();
			errors.put(fieldname,message);
			
		});
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}

}
