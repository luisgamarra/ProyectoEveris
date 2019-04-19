package com.everis.gamarra.controller;

import com.everis.gamarra.model.Parent;
import com.everis.gamarra.model.Student;
import com.everis.gamarra.model.StudentParent;
import com.everis.gamarra.service.dao.StudentParentServiceImpl;
import com.everis.gamarra.model.StudentParentPK;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.everis.gamarra.utility.JsonString.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentParentController.class)
public class StudentParentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentParentServiceImpl service;

	@Test
	public void getAllStudentParents() throws Exception{

		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/student-parents"))
						.andExpect(status().isOk())
						.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

	@Test
	public void addStudentParents() throws Exception{

		Parent parent = new Parent();
		parent.setId(1);

		Student student = new Student();
		student.setId(1);

		StudentParent studentParent = new StudentParent();
		studentParent.setParent(parent);
		studentParent.setStudent(student);

		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1.0/student-parents/")
						.accept("application/json")
						.contentType("application/json")
						.content(asJsonString(studentParent)))
						.andExpect(status().isCreated());


	}

	@Test
	public void updateStudentParents() throws Exception{

		Parent parent = new Parent();
		parent.setId(1);

		Student student = new Student();
		student.setId(1);

		StudentParentPK studentParentPK = new StudentParentPK();
		studentParentPK.setStudentId(student.getId());
		studentParentPK.setParentId(parent.getId());

		StudentParent studentParent = new StudentParent();
		studentParent.setStudentParentPK(studentParentPK);
		studentParent.setParent(parent);
		studentParent.setStudent(student);

		this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1.0/student-parents/")
						.accept("application/json")
						.contentType("application/json")
						.content(asJsonString(studentParent)))
						.andExpect(status().isOk());

	}

	@Test
	public void deleteStudentParents() throws Exception{

		Parent parent = new Parent();
		parent.setId(1);

		Student student = new Student();
		student.setId(1);

		StudentParentPK studentParentPK = new StudentParentPK();
		studentParentPK.setParentId(parent.getId());
		studentParentPK.setStudentId(student.getId());

	/*	StudentParent studentParent = new StudentParent();
		studentParent.setStudentParentPK(studentParentPK);
		studentParent.setParent(Parent);
		studentParent.setStudent(student);*/

		this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1.0/student/{stuid}/Parent/{pareid}",
						studentParentPK.getStudentId(),studentParentPK.getParentId()))
						.andExpect(status().isOk());

	}

	@Test
	public void getStudentParent() throws Exception{

		Parent parent = new Parent();
		parent.setId(1);

		Student student = new Student();
		student.setId(1);

		/*StudentParent studentParent = new StudentParent();
		studentParent.setParent(Parent);
		studentParent.setStudent(student);*/

		StudentParentPK pk = new StudentParentPK();
		pk.setStudentId(student.getId());
		pk.setParentId(parent.getId());

		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0//student/{stuid}/Parent/{pareid}",
						pk.getStudentId(),pk.getParentId()))
						.andExpect(status().isOk());


	}

}