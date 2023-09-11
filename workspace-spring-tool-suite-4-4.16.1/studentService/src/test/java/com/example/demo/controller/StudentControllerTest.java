package com.example.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.model.AddStudentException;
import com.example.demo.model.NoSuchStudentException;
import com.example.demo.model.Response;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

public class StudentControllerTest {
	
	
	@InjectMocks
    private StudentController studentController;
	
	@Autowired
	private MockMvc mockMvc;
	
    @Mock
    private StudentService studentService;

    @BeforeEach
    public void setUp() {
    	MockitoAnnotations.initMocks(this);
    	mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

    }
    
    
    @Test
    public void testGetAllStudents() throws Exception {
    	
    	List<Student> lst = new ArrayList<>();
    	lst.add(new Student(1,"harry","potter",3,"hogward"));
    	lst.add(new Student(1,"ron","weasly",4,"hogward"));
    	
    	when(studentService.getAllStudent()).thenReturn(lst);
    	
    	mockMvc.perform(get("/student/getAllStudent")).andExpect(status().isOk());
    	
    	
    }
    
    @Test
    public void testGetStudentById() throws Exception {
    	int studentId = 1;
    	
    	Student s= new Student(studentId,"harry","potter",3,"hogwards");
    	
    	when(studentService.getStudentById(studentId)).thenReturn(s);
    	
    	mockMvc.perform(get("/student/getStudent/{studentId}", studentId))
    		.andExpect(status().isOk());
    			
    	
    }
    
    @Test
    public void testAddStudent() throws AddStudentException,Exception {
    	
    	Student mockStudent = new Student();
        mockStudent.setFname("harry");
        mockStudent.setLname("potter");
        mockStudent.setRollno(123);
        mockStudent.setCity("hogwards");
        
    	Student student = new Student();
    	when(studentService.addStudent(student)).thenReturn(student);
    	
//    	mockMvc.perform(post("/student/addStudent")
//    			.contentType(MediaType.APPLICATION_JSON))
//    			.andExpect(status().isOk());
    	
    	 mockMvc.perform(post("/student/addStudent")
                 .contentType(MediaType.APPLICATION_JSON)
                 .content("{\"fname\":\"harry\",\"lname\":\"potter\",\"rollno\":123,\"city\":\"hogwards\"}"))
                 .andExpect(status().isOk());
    	
    }
    
    @Test
    public void testchangeFName() throws Exception {
    	
    	int studentId = 1;
    	
    	Student student = new Student();
    	when(studentService.changeFName(studentId, student)).thenReturn(student);
    	
    	mockMvc.perform(put("/student/changeFName/" + studentId)
    			.contentType(MediaType.APPLICATION_JSON)
    			.content("{\"fname\":\"harry\",\"lname\":\"potter\",\"rollno\":123,\"city\":\"hogwards\"}"))
    			.andExpect(status().isOk());
    }
    
    
    @Test
    public void testchangeFNameInvalid() throws Exception {
    	
    	int studentId = 0;
    	
    	Student student = new Student();
    	when(studentService.changeFName(any(Integer.class), any(Student.class))).thenThrow(new NoSuchStudentException());
//    	System.out.println(studentService.changeFName(studentId, student));
    	mockMvc.perform(put("/student/changeFName/" + studentId)
    			.contentType(MediaType.APPLICATION_JSON)
    			.content("{\"fname\":\"harry\",\"lname\":\"potter\",\"rollno\":123,\"city\":\"hogwards\"}"))
    			.andExpect(status().isBadRequest());
    }

    @Test
    public void testDeleteStudent() throws Exception {
    	
    	int studentId =1;
    	Student student = new Student();

    	when(studentService.deleteStudent(studentId)).thenReturn(new Response());
    	
    	mockMvc.perform(delete("/student/deleteStudent/{studentId}",studentId)).andExpect(status().isOk());
    			
    }
    


    
    
}












