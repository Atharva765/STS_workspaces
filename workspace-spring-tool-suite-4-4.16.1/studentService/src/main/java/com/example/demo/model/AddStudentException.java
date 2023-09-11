package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddStudentException extends Exception{
	
	private String msg;
	

}
