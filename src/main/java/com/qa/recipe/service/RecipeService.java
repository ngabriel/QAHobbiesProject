package com.qa.recipe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.recipe.dto.RecipeDTO;
import com.qa.recipe.exceptions.RecipeNotFoundException;
import com.qa.recipe.persistence.domain.Recipe;
import com.qa.recipe.persistence.repo.RecipeRepo;
import org.modelmapper.ModelMapper;

@Service
public class RecipeService {
	
	private RecipeRepo repo;
	
	private ModelMapper mapper;

	public RecipeService(RecipeRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	public RecipeDTO mapToDto(Recipe recipe) {
		return this.mapper.map(recipe, RecipeDTO.class);
		
	}
	
	
	public RecipeDTO create(Recipe recipe) {
		
		return mapToDto(this.repo.save(recipe));
		
	}
	
	public List<RecipeDTO> read(){
		List<Recipe> allRecipes = this.repo.findAll();
		List<RecipeDTO> allRecipeDTO = new ArrayList<>();
		for (int i = 0; i < allRecipes.size(); i++) {
			Recipe newRec = allRecipes.get(i);
			allRecipeDTO.add(mapToDto(newRec));
			
			
		}
		return allRecipeDTO;
		
	}
	public RecipeDTO read(long id){
		Recipe found = this.repo.findById(id).orElseThrow(() -> new RecipeNotFoundException());
		return this.mapToDto(found);
	}
	public RecipeDTO update(Recipe recipe, long id) {
//		RecipeDTO toUpdate = this.repo.findById(id).orElseThrow(() -> new RecipeNotFoundException());
//		toUpdate.setName(recipe.getName());
//		toUpdate.setIngredient(recipe.getIngredient());
//		toUpdate.setMethod(recipe.getMethod());
//		
//		return this.repo.save(toUpdate);
		Optional<Recipe> optRecipe = this.repo.findById(id);
		Recipe toUpdate = optRecipe.orElseThrow(() -> new RecipeNotFoundException());
		toUpdate.setName(recipe.getName());
		toUpdate.setMethod(recipe.getMethod());
		Recipe updated = this.repo.save(toUpdate);
		return this.mapToDto(updated);
		
	}
	
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	

}
