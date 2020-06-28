package com.qa.recipe.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.qa.recipe.exceptions.RecipeNotFoundException;
import com.qa.recipe.persistence.domain.Recipe;
import com.qa.recipe.persistence.repo.RecipeRepo;

@Service
public class RecipeService {
	
	private RecipeRepo repo;

	public RecipeService(RecipeRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Recipe create(Recipe recipe) {
		return this.repo.save(recipe);
		
	}
	
	public List<Recipe> read(){
		return this.repo.findAll();
		
	}
	public Recipe read(long id){
		return this.repo.findById(id).orElseThrow(() -> new RecipeNotFoundException());
		
	}
	public Recipe update(Recipe recipe, long id) {
		Recipe toUpdate = this.repo.findById(id).orElseThrow(() -> new RecipeNotFoundException());
		toUpdate.setName(recipe.getName());
		toUpdate.setIngredient(recipe.getIngredient());
		toUpdate.setMethod(recipe.getMethod());
		
		return this.repo.save(toUpdate);
		
		
	}
	
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	

}
