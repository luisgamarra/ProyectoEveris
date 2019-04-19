package com.everis.gamarra.controller;

import com.everis.gamarra.model.Family;
import com.everis.gamarra.model.Parent;
import com.everis.gamarra.service.dao.FamilyServiceImpl;
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
@WebMvcTest(FamilyController.class)
public class FamilyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FamilyServiceImpl service;

	@Test
	public void getAllFamilies() throws Exception{
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/families"))
						.andExpect(status().isOk())
						.andExpect(content().contentType("application/json;charset=UTF-8"));
	}

	@Test
	public void findByFamilyId() throws Exception {
		Family family = new Family();
		family.setId(1);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/families/{id}",family.getId()))
						.andExpect(status().isOk());

	}

	@Test
	public void addFamily() throws Exception{

		Family family = new Family();
		Parent parent = new Parent();
		parent.setId(8);
		family.setHeadOfFamilyParent(parent);
		family.setFamilyName("Familia Nuñez");

		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1.0/families")
						.accept("application/json")
						.contentType("application/json")
						.content(asJsonString(family)))
						.andExpect(status().isCreated());
	}

	@Test
	public void updateFamily() throws Exception{

		Family family = new Family();
		Parent parent = new Parent();
		parent.setId(8);
		family.setId(11);
		family.setHeadOfFamilyParent(parent);
		family.setFamilyName("Familia Nuñez");

		this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1.0/families")
						.accept("application/json")
						.contentType("application/json")
						.content(asJsonString(family)))
						.andExpect(status().isOk());
	}

	@Test
	public void deleteFamily() throws Exception{

		Family family = new Family();
		family.setId(11);

		this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1.0/families/{id}",family.getId()))
						.andExpect(status().isOk());
	}


}