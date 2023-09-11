package com.example.demo.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoSuchStudentException extends RuntimeException {
	
	private String message;
	private HttpStatus notFound;
	
    
}
