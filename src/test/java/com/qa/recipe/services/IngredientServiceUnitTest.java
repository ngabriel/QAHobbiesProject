package com.qa.recipe.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;


import com.qa.recipe.dto.IngredientDTO;
import com.qa.recipe.persistence.domain.Ingredient;
import com.qa.recipe.persistence.repo.IngredientRepo;
import com.qa.recipe.persistence.repo.RecipeRepo;
import com.qa.recipe.service.IngredientService;

@RunWith(MockitoJUnitRunner.class)
public class IngredientServiceUnitTest {
	
	private final Ingredient INGREDIENT = new Ingredient("apple");
	private Ingredient savedIngredient;
	
	private IngredientDTO ingredientDTO;
	private List<Ingredient> ingredientList;

	@Mock
	private ModelMapper mapper;
	
	@Mock
	private IngredientRepo Irepo;
	
	@Mock
	private RecipeRepo Rrepo;
	
	@InjectMocks
	private IngredientService service;
	
	@Before
	public void init() {
		this.savedIngredient = new Ingredient(INGREDIENT.getName());
		this.ingredientList = new ArrayList<>();
		this.ingredientList.add(savedIngredient);
		
		this.ingredientDTO = new ModelMapper().map(savedIngredient, IngredientDTO.class);
	}
	
	
	@Test
	public void testCreate() {
		
		
		
		
		Mockito.when(this.Irepo.save(INGREDIENT)).thenReturn(savedIngredient);
		
		when(this.mapper.map(savedIngredient, IngredientDTO.class)).thenReturn(ingredientDTO);
		System.out.println(this.ingredientDTO.getName());
		System.out.println(INGREDIENT.getName());
		assertEquals(this.ingredientDTO.getName(), INGREDIENT.getName());
		
		
//		assertEquals("Ingredient [id=1, name=apple, recipes=[]]", savedIngredient);
//		Mockito.verify(this.Irepo, Mockito.times(1)).save(INGREDIENT);
	}

	@Test
	public void testRead() {
		when(Irepo.findAll()).thenReturn(this.ingredientList);
		when(this.mapper.map(savedIngredient, IngredientDTO.class)).thenReturn(ingredientDTO);

		assertEquals(this.ingredientDTO, this.service.read());

		verify(Irepo, times(1)).findAll();
	}

	@Test
	public void testUpdate() {
		
		//Ingredient oldIngredient = new Ingredient("banana");
		//Mockito.when(this.Irepo.findByName(savedIngredient.getName())).thenReturn(savedIngredient);
		
		String newNameStr = "pineapple";
		Mockito.when(this.Irepo.findByName(savedIngredient.getName())).thenReturn(savedIngredient);
		
	
		Ingredient newIngredientName = savedIngredient;
		newIngredientName.setName(newNameStr);
		
		
		
//		Mockito.when(this.Irepo.save(newIngredientName)).thenReturn(newIngredientName);
		System.out.println(newIngredientName.getName());
		System.out.println(savedIngredient.getName());
		
		assertEquals(newIngredientName.getName(), savedIngredient.getName());
		
		
	}
	
	
	
	
		@Test
		public void testDelete() {
			String nameIng = savedIngredient.getName();
			final boolean RESULT = false;
			
			Mockito.when(this.Irepo.existsByName(nameIng)).thenReturn(true, false);
			
			System.out.println(RESULT);
			System.out.println(nameIng);
			assertEquals(RESULT, this.service.delete(nameIng));
			
			Mockito.verify(this.Irepo, Mockito.times(2)).existsByName(nameIng);
		}
		
		
	
	 
	

}
