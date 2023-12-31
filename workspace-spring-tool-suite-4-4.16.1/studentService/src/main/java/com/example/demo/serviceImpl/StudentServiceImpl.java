package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.AddStudentException;
import com.example.demo.model.ErrorResponse;
import com.example.demo.model.NoSuchStudentException;
import com.example.demo.model.Response;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
		
	@Autowired
	private StudentRepository studentRepository;
	
	/**
     * {@inheritDoc}
     */
	@Override
	public List<Student> getAllStudent() {
		
		return studentRepository.findAll();
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public Student addStudent(Student student) throws AddStudentException {
		
		if(student.getFname() == null)
			throw new AddStudentException("First Name Cannot be NULL");
		
		return studentRepository.save(student);
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public Student changeFName(int studentId, Student student) throws AddStudentException {
		
		
			if(student.getFname() == null)
				throw new AddStudentException("First Name Cannot be NULL"); 
			
			Student s = studentRepository.findById(studentId).orElseThrow(
					()-> new NoSuchStudentException("No Student present with ID= " + studentId, HttpStatus.NOT_FOUND));
			
			s.setFname(student.getFname());
			return studentRepository.save(s) ;
		
	}
	
	/**
     * {@inheritDoc}
     */
	@Override
	public Response deleteStudent(int studentId) throws NoSuchStudentException {
		
		Student s = studentRepository.findById(studentId).orElseThrow(
					()-> new NoSuchStudentException("No Student present with ID= " + studentId, HttpStatus.NOT_FOUND));
		studentRepository.delete(s);
			
		Response response = new Response();
		
		response.setMessage("Student Deleted!");
		return response;
		
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public Student getStudentById(int studentId)  throws NoSuchStudentException {
		
		return studentRepository.findById(studentId).orElseThrow(
				()-> new NoSuchStudentException("No Student present with ID= " + studentId, HttpStatus.NOT_FOUND));
		
	}

}
