package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AddStudentException;
import com.example.demo.model.ErrorResponse;
import com.example.demo.model.NoSuchStudentException;
import com.example.demo.model.Response;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
	
	 @Autowired
	private StudentService studentService;
	 
	 
//	 @Autowired
//	 private StudentRepository studentRepository;
//	 @PostMapping("/create-multiple")
//	 public List<Student> createStudents(@RequestBody List<Student> students) {
//		 return studentRepository.saveAll(students);
//	 }
	
	@GetMapping(value = "/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getStudent/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable int studentId){
		return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) throws AddStudentException{
		return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK );
	}
	
	@PutMapping(value = "/changeFName/{studentId}")
	public ResponseEntity<Student> changeFName(@PathVariable int studentId, @RequestBody Student student) throws AddStudentException{
		try {
			return new ResponseEntity<>(studentService.changeFName(studentId,student),HttpStatus.OK);
		}
		catch (NoSuchStudentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping(value = "/deleteStudent/{studentId}")
    public ResponseEntity<Response> deleteStudent(@PathVariable int studentId) {
			
		try {
			
			return new ResponseEntity<>(studentService.deleteStudent(studentId),HttpStatus.OK);
		} catch (NoSuchStudentException e) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
        
	}
}
