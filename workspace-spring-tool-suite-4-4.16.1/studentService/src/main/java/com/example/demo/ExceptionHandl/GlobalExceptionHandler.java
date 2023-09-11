package com.example.demo.ExceptionHandl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.model.AddStudentException;

import com.example.demo.model.ErrorResponse;
import com.example.demo.model.NoSuchStudentException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = NoSuchStudentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse
	handleException(NoSuchStudentException ex)
    {
        return new ErrorResponse(
            HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
	
	
	@ExceptionHandler(value = AddStudentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorResponse
	handleException(AddStudentException ex)
    {
        return new ErrorResponse(
            HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }
	
	
}
