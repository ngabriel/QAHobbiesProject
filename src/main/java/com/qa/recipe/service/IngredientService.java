package com.qa.recipe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.recipe.dto.IngredientDTO;
import com.qa.recipe.exceptions.IngredientNotFoundException;
import com.qa.recipe.persistence.domain.Ingredient;
import com.qa.recipe.persistence.repo.IngredientRepo;

@Service
public class IngredientService {
	
	private IngredientRepo repo;
	private ModelMapper mapper;

	public IngredientService(IngredientRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private IngredientDTO mapToDTO(Ingredient ingredient) {
		return this.mapper.map(ingredient, IngredientDTO.class);
	}
	
	public IngredientDTO create(Ingredient ingredient) {
		Ingredient saved = this.repo.save(ingredient);
		return this.mapToDTO(saved);
	}
	
	public List<IngredientDTO> read(){
		List<IngredientDTO> dtos = new ArrayList<>();
		for (Ingredient ingredient : this.repo.findAll()) {
			dtos.add(this.mapToDTO(ingredient));
		}
		return dtos;
	}
	public IngredientDTO read(long id){
		Ingredient found = this.repo.findById(id).orElseThrow(() -> new IngredientNotFoundException());
		return this.mapToDTO(found);
	}
	
	public IngredientDTO update(Ingredient ingredient, long id) {
		Optional<Ingredient> optIngredient = this.repo.findById(id);
		Ingredient toUpdate = optIngredient.orElseThrow(() -> new IngredientNotFoundException());
		
		toUpdate.setName(ingredient.getName());
		Ingredient updated = this.repo.save(toUpdate);
		
		return this.mapToDTO(updated);
		
	}
	
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	
	

}
