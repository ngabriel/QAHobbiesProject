package com.qa.recipe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.recipe.exceptions.IngredientNotFoundException;
import com.qa.recipe.persistence.domain.Ingredient;
import com.qa.recipe.persistence.repo.IngredientRepo;

@Service
public class IngredientService {
	
	private IngredientRepo repo;

	public IngredientService(IngredientRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Ingredient create(Ingredient ingredient) {
		return this.repo.save(ingredient);
		
	}
	
	public List<Ingredient> read(){
		return this.repo.findAll();
		
	}
	public Ingredient read(long id){
		return this.repo.findById(id).orElseThrow(() -> new IngredientNotFoundException());
		
	}
	public Ingredient update(Ingredient ingredient, long id) {
		Ingredient toUpdate = this.repo.findById(id).orElseThrow(() -> new IngredientNotFoundException());
		toUpdate.setName(ingredient.getName());
		
		return this.repo.save(toUpdate);
		
		
	}
	
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	
	

}
