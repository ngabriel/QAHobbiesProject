package com.qa.recipe.services;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.recipe.dto.IngredientDTO;
import com.qa.recipe.persistence.domain.Ingredient;
import com.qa.recipe.persistence.repo.IngredientRepo;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class IngredientControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMVC;
	
	@Autowired
	private IngredientRepo repo;
	
	@Autowired
	private ObjectMapper mapper;
	
	private long id;

	private Ingredient ingredient;
	
	private Ingredient savedIngredient;
	
	private IngredientDTO savedIngredientDTO;
	
	private String ingName;
	
	private IngredientDTO mapToDTO(Ingredient ingredient) {
		return new ModelMapper().map(ingredient, IngredientDTO.class);
	}
	
	@Before
	public void init() {
		this.repo.deleteAll();
		this.ingredient = new Ingredient("wine");
		
		//Ingredient savedIngredient = new Ingredient(ingredient.getName());
		this.savedIngredient = this.repo.save(this.ingredient);
		this.id = this.savedIngredient.getId();
		//savedIngredient.setId(1L);
		ingName = savedIngredient.getName();
		this.savedIngredientDTO = mapToDTO(savedIngredient);
	}
	
//	@Test
//	public void testCreate() throws Exception {
//		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/ingredient/create");
//		reqBuilder.accept(MediaType.APPLICATION_JSON);
//		reqBuilder.accept(MediaType.APPLICATION_JSON);
//		reqBuilder.content(this.mapper.writeValueAsString(ingredient));
//		
//		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
//		ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(savedIngredient));
//		this.mockMVC.perform(reqBuilder).andExpect(matchStatus).andExpect(matchContent);
//	}
	
	@Test
	public void testCreateBuilder() throws JsonProcessingException, Exception {
		this.mockMVC.perform(post("/ingredient/create").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(ingredient))).andExpect(status()
				.isCreated()).andExpect(content().json(this.mapper.writeValueAsString(savedIngredientDTO)));
	}
	
	
	
	@Test
	public void readAllIngredients() throws Exception{
		List<IngredientDTO> ingredList = new ArrayList<>();
		ingredList.add(this.savedIngredientDTO);
		
		String content = this.mockMVC.perform(request(HttpMethod.
				GET, "/ingredient/read").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(ingredList), content);

	}
	@Test
	public void updateIngredient() throws UnsupportedEncodingException, JsonProcessingException, Exception {
		Ingredient newIngred = new Ingredient("honey");
		Ingredient updatedIngred = new Ingredient(newIngred.getName());
		updatedIngred.setId(1l);
		
		String result = this.mockMVC   
				.perform(request(HttpMethod.PUT, "/ingredient/update/" + ingName + "?name=" + newIngred.getName())
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(ingredient)))
						.andExpect(status().isAccepted()).andReturn().getResponse()
						.getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(this.mapToDTO(updatedIngred)), result);
		
	}
	

	
	
	@Test
	public void testDeleteIngredient() throws Exception {
		this.mockMVC.perform(request(HttpMethod.DELETE, "/ingredient/delete" + ingName)).andExpect(status().isNotFound());
	}
	
}
