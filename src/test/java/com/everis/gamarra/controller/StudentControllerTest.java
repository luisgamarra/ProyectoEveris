package com.everis.gamarra.controller;

import com.everis.gamarra.model.Student;
import com.everis.gamarra.service.dao.StudentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static com.everis.gamarra.utility.JsonString.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentServiceImpl service;

	@Test
	public void getAllStudents() throws Exception{
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/students"))
						.andExpect(status().isOk())
						.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

	@Test
	public void addStudent() throws Exception {

		Student student = new Student();
		student.setGender("F");
		student.setFirstName("Dana");
		student.setMiddleName("Lucia");
		student.setLastName("Gamarra");
		student.setDateOfBirth(new Date());
		student.setOtherStudentDetails("Hija");

		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1.0/students")
						.accept("application/json")
						.contentType("application/json")
						.content(asJsonString(student)))
						.andExpect(status().isCreated());

	}

	@Test
	public void updateStudent() throws Exception{
		Student student = new Student();
		student.setId(10);
		student.setGender("F");
		student.setFirstName("Dana");
		student.setMiddleName("Lucia");
		student.setLastName("Gamarra");
		student.setDateOfBirth(new Date());
		student.setOtherStudentDetails("Hija");

		this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1.0/students")
						.accept("application/json")
						.contentType("application/json")
						.content(asJsonString(student)))
						.andExpect(status().isOk());
	}

	@Test
	public void deleteStudent() throws Exception{
		Student student = new Student();
		student.setId(10);

		this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1.0/students/{id}",student.getId()))
						.andExpect(status().isOk());
	}
}