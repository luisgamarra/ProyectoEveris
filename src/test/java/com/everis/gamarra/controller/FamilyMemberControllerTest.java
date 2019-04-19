package com.everis.gamarra.controller;

import com.everis.gamarra.model.Family;
import com.everis.gamarra.model.FamilyMember;
import com.everis.gamarra.model.Parent;
import com.everis.gamarra.model.Student;
import com.everis.gamarra.service.dao.FamilyMemberServiceImpl;
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
@WebMvcTest(FamilyMemberController.class)
public class FamilyMemberControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FamilyMemberServiceImpl service;

	@Test
	public void getAllFamiliMembers() throws Exception{
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/family-members"))
						.andExpect(status().isOk())
						.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

	@Test
	public void addFamilyMember() throws Exception{

		Family family = new Family();
		family.setId(1);
		Parent parent = new Parent();
		parent.setId(1);
		Student student = new Student();
		student.setId(1);

		FamilyMember familyMember = new FamilyMember();
		familyMember.setFamily(family);
		familyMember.setParent(parent);
		familyMember.setParentOrStudentMember("Student");
		familyMember.setStudent(student);

		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1.0/family-members")
						.accept("application/json")
						.contentType("application/json")
						.content(asJsonString(familyMember)))
						.andExpect(status().isCreated());
	}

	@Test
	public void updateFamilyMember() throws Exception{

		Family family = new Family();
		family.setId(1);
		Parent parent = new Parent();
		parent.setId(1);
		Student student = new Student();
		student.setId(1);

		FamilyMember familyMember = new FamilyMember();
		familyMember.setId(1);
		familyMember.setFamily(family);
		familyMember.setParent(parent);
		familyMember.setParentOrStudentMember("Student");
		familyMember.setStudent(student);

		this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1.0/family-members")
						.accept("application/json")
						.contentType("application/json")
						.content(asJsonString(familyMember)))
						.andExpect(status().isOk());
	}

	@Test
	public void deleteFamilyMember() throws Exception{

		FamilyMember familyMember = new FamilyMember();
		familyMember.setId(20);

		this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1.0/family-members/{id}",familyMember.getId()))
						.andExpect(status().isOk());
	}
}