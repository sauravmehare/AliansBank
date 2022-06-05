package com.aliens.exception;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<ErrorResponce> handleAccountNotFoundException(AccountNotFoundException ex){
		ErrorResponce errorResponce=new ErrorResponce();
		errorResponce.setMessage(ex.getMessage());
		errorResponce.setDateTime(LocalDateTime.now());
		errorResponce.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponce>(errorResponce,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BeneficiaryNotFoundException.class)
	public ResponseEntity<ErrorResponce> handleBeneficiaryNotFoundException(BeneficiaryNotFoundException ex){
		ErrorResponce errorResponce=new ErrorResponce();
		errorResponce.setMessage(ex.getMessage());
		errorResponce.setDateTime(LocalDateTime.now());
		errorResponce.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponce>(errorResponce,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ZeroAmountExceprion.class)
	public ResponseEntity<ErrorResponce> handleZeroAmountExceprion(ZeroAmountExceprion ex){
		ErrorResponce errorResponce=new ErrorResponce();
		errorResponce.setMessage(ex.getMessage());
		errorResponce.setDateTime(LocalDateTime.now());
		errorResponce.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponce>(errorResponce,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerAlreadyExistException.class)
	public ResponseEntity<ErrorResponce> handleCustomerAlreadyExistException(CustomerAlreadyExistException ex){
		ErrorResponce errorResponce=new ErrorResponce();
		errorResponce.setMessage(ex.getMessage());
		errorResponce.setDateTime(LocalDateTime.now());
		errorResponce.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponce>(errorResponce,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponce> handleCustomerNotFoundException(CustomerNotFoundException ex){
		ErrorResponce errorResponce=new ErrorResponce();
		errorResponce.setMessage(ex.getMessage());
		errorResponce.setDateTime(LocalDateTime.now());
		errorResponce.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorResponce>(errorResponce,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponce> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		List<FieldError> errors=ex.getFieldErrors();
		ValidationErrorResponce validationErrorResponce=new ValidationErrorResponce();
		for(FieldError error:errors){
			validationErrorResponce.getErrors().put(error.getField(), error.getDefaultMessage());
		}
		
		validationErrorResponce.setDateTime(LocalDateTime.now());
		validationErrorResponce.setStatusCode(HttpStatus.BAD_REQUEST.value());
		validationErrorResponce.setMessage("Please input proper data");
		
		return new ResponseEntity<ValidationErrorResponce>(validationErrorResponce,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ValidationErrorResponce> handleConstraintViolationException(ConstraintViolationException ex){
		ValidationErrorResponce validationErrorResponce=new ValidationErrorResponce();
		validationErrorResponce.setDateTime(LocalDateTime.now());
		validationErrorResponce.setStatusCode(HttpStatus.BAD_REQUEST.value());
		validationErrorResponce.setMessage("Please input proper data");
		
		ex.getConstraintViolations().forEach(error ->{
			validationErrorResponce.getErrors().put("field", error.getMessage());
		});
		
		return new ResponseEntity<ValidationErrorResponce>(validationErrorResponce,HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(EntityNotFoundException.class)
//	public ResponseEntity<ValidationErrorResponce> handleMethodEntityNotFoundException(EntityNotFoundException ex){
//		ValidationErrorResponce validationErrorResponce=new ValidationErrorResponce();
//		validationErrorResponce.setDateTime(LocalDateTime.now());
//		validationErrorResponce.setStatusCode(HttpStatus.BAD_REQUEST.value());
//		validationErrorResponce.setMessage(ex.getMessage());
//		return new ResponseEntity<ValidationErrorResponce>(validationErrorResponce,HttpStatus.BAD_REQUEST);
//	}

}
