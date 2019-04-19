package com.everis.gamarra.controller;

import com.everis.gamarra.model.Parent;
import com.everis.gamarra.service.dao.ParentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.everis.gamarra.utility.JsonString.asJsonString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ParentController.class)
public class ParentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ParentServiceImpl service;

	@Test
	public void findAllParents() throws Exception{

				this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/parents"))
								.andExpect(status().isOk())
								.andExpect(content().contentType("application/json;charset=UTF-8"));

	}

	@Test
	public void addParent() throws Exception{


		Parent parent = new Parent();
		parent.setGender("F");
		parent.setFirstName("Johana");
		parent.setMiddleName("Dina");
		parent.setLastName("Gonzales");
		parent.setOtherParentDetails("Madre de familia");

		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1.0/parents")
						.accept("application/json")
						.contentType("application/json")
						.content(asJsonString(parent)))
						.andExpect(status().isCreated());

	}

	@Test
	public void updateParent() throws Exception{
		Parent parent = new Parent();
		parent.setId(15);
		parent.setGender("F");
		parent.setFirstName("Johana");
		parent.setMiddleName("Dina");
		parent.setLastName("Gonzales");
		parent.setOtherParentDetails("Madre de familia");

		this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1.0/parents")
						.accept("application/json")
						.contentType("application/json")
						.content(asJsonString(parent)))
						.andExpect(status().isOk());

	}

	@Test
	public void deleteParent() throws Exception{
		Parent parent = new Parent();
		parent.setId(6);

		this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1.0/parents/{id}",parent.getId()))
						.andExpect(status().isOk());

	}

}