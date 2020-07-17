package com.qa.recipe.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.recipe.persistence.domain.Ingredient;
import com.qa.recipe.persistence.repo.IngredientRepo;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration
public class IngredientRepoTest {
	
	
	
	@Autowired
	private IngredientRepo repo;
	
	private final String TEST_NAME = "Recipe 1";
	
	private final Ingredient TEST_INGREDIENT = new Ingredient(TEST_NAME);
	
	private Ingredient testSavedIngredient;
	
	@Before
	public void init() {
		this.repo.deleteAll();
		this.testSavedIngredient = this.repo.save(this.testSavedIngredient);
	}
//	@Test
//	public void testFindByName() {
//		assertThat(this.repo.findByColour(this.TEST_COLOUR)).containsExactly(this.testSavedDuck);
//	}
	@Test
	public void testFindByID() {
		System.out.println(this.repo.existsByName(this.TEST_NAME));
		assertNotNull(this.repo.existsByName(this.TEST_NAME));
		//Assert.assertThat(this.repo.findByName(TEST_NAME))
		
	}



}
