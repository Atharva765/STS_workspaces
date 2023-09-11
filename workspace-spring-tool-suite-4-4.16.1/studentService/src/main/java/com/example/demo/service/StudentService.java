package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.AddStudentException;
import com.example.demo.model.ErrorResponse;
import com.example.demo.model.Response;
import com.example.demo.model.Student;

public interface StudentService {
	
	
	/**
     * return a {@link List}&lt;{@link Student}&gt; objects.
     * @return {@link List}&lt;{@link Student}&gt;
    */
	List<Student> getAllStudent(); 
		
	/**
     * Creates new Student
     * @param student {@link Student} student to query
     * @return {@link Student} creates Student object
     * @throws AddStudentException 
     */
	Student addStudent(Student student) throws AddStudentException;

	/**
     * Performs updates for a provided {@link Student} student.
     * @param documentId {@link Integer} studentId to update
     * @param student {@link Student} student to persist
     * @return {@link Student}
	 * @throws AddStudentException 
     */
	Student changeFName(int studentId, Student student) throws AddStudentException;

	/**
     * Deletes the student for a provided {@link Integer} studentId.
     * @param studentId {@link Integer} studentId to delete
     * @return {@link Response}
     */
	Response deleteStudent(int studentId);
	
	/**
     * For a given {@link Integer} studentId, return the corresponding
     * {@link Student} object.
     * @param studentId {@link Long} studentId to return
     * @return {@link Student}
     * 
     */
	Student getStudentById(int studentId);
}
