package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.AddStudentException;
import com.example.demo.model.NoSuchStudentException;
import com.example.demo.model.Response;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.serviceImpl.StudentServiceImpl;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

@SpringBootTest
public class StudentServiceTest {
	
	private StudentRepository studentRepository = Mockito.mock(StudentRepository.class);
	
	@InjectMocks
	StudentServiceImpl studentService;
	
	@Test
	public void testGetStudentById() {
		
		Student student = new Student(1,"harry","potter",3,"hogwards");
		
		when(studentRepository.findById(any(Integer.class))).thenReturn(Optional.of(student));
		//when(studentService.getStudentById(1)).thenReturn(student);
		Student s2 = studentService.getStudentById(1);
		
		assertEquals(student, s2);
		
	}
	
	@Test
	public void testAddStudent() {
		
		Student student = new Student(1,"harry","potter",3,"hogwards");
		
		when(studentRepository.save(student)).thenReturn(student);
		try {
			 Student s2 =  studentService.addStudent(student);
			 
		} catch (AddStudentException e) {
			assertEquals("First Name Cannot be NULL", e.getMsg());
			
		}
		
	}
	
	@Test
	public void testfailAddStudent() {
		
		Student student = new Student(1,null,"potter",3,"hogwards");
		
		when(studentRepository.save(student)).thenReturn(student);
		try {
			 Student s2 =  studentService.addStudent(student);
			 
		} catch (AddStudentException e) {
			assertEquals("First Name Cannot be NULL", e.getMsg());
		}
		
	}
	
	@Test
	public void testChangeFName_ValidInput() throws AddStudentException {
		int studentId = 1;
		Student exStudent = new Student();
		exStudent.setFname("Harry");
		Student updateStudent = new Student();
		updateStudent.setFname("Jerry");
		
		
		when(studentRepository.findById(1)).thenReturn(Optional.of(exStudent));
		when(studentRepository.save(any())).thenReturn(updateStudent);
		
		Student result = studentService.changeFName(studentId, updateStudent);
		
		assertEquals("Jerry", result.getFname());
		
		
	}
	
	
	@Test
	public void testChangeFName_InValidInput() throws AddStudentException {
		int studentId = 1;
		Student exStudent = new Student();
		exStudent.setFname(null);
		
		AddStudentException ex = assertThrows(AddStudentException.class, ()->{
			studentService.changeFName(studentId, exStudent);
		});
		
		
		assertEquals("First Name Cannot be NULL", ex.getMsg());
		
		
	}
	
	
	
	@Test
	public void NoSuchStudentExceptionTest() throws NoSuchStudentException {
		
		int studentId = 1;
		Student exStudent = new Student();
		exStudent.setFname("harry");
		
		when(studentRepository.findById(1)).thenReturn(Optional.empty());
		
		NoSuchStudentException ex = assertThrows(NoSuchStudentException.class, ()->{
			studentService.changeFName(studentId, exStudent);
		});
		
		
		
		assertEquals("No Student present with ID= "+ studentId, ex.getMessage());
		assertEquals(HttpStatus.NOT_FOUND, ex.getNotFound());
		
	}
	
	@Test
	public void testGetAllStudent() {
		
		
		List<Student> lst = new ArrayList<>();
		when(studentRepository.findAll()).thenReturn(lst);
		
		List<Student> lst2 = studentService.getAllStudent();
		
		assertNotNull(lst2);
		
	}
	
	
	@Test
	public void testDeleteStudent_validInput() {
		
		int studentId = 1; 
		Student s = new Student();
		
		when(studentRepository.findById(studentId)).thenReturn(Optional.of(s));
		
		 Response result = studentService.deleteStudent(studentId);
		 
		 assertEquals("Student Deleted!", result.getMessage());
	}
	
}










