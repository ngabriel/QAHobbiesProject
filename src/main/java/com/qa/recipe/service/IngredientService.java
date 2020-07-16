package com.qa.recipe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import com.qa.recipe.dto.IngredientDTO;
import com.qa.recipe.exceptions.IngredientNotFoundException;
import com.qa.recipe.exceptions.RecipeNotFoundException;
import com.qa.recipe.persistence.domain.Ingredient;
import com.qa.recipe.persistence.domain.Recipe;
import com.qa.recipe.persistence.repo.IngredientRepo;
import com.qa.recipe.persistence.repo.RecipeRepo;
import com.qa.recipe.utils.Utility;

@Service
public class IngredientService {

	private IngredientRepo repo;
	private ModelMapper mapper;
	private RecipeRepo rRepo;

	public IngredientService(IngredientRepo repo, ModelMapper mapper, RecipeRepo rRepo) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		this.rRepo = rRepo;
	}

	private IngredientDTO mapToDTO(Ingredient ingredient) {
		return this.mapper.map(ingredient, IngredientDTO.class);
	}

	public IngredientDTO create(Ingredient ingredient) {
		Ingredient saved = this.repo.save(ingredient);
		return this.mapToDTO(saved);
	}

	public List<IngredientDTO> read() {
		List<IngredientDTO> dtos = new ArrayList<>();
		for (Ingredient ingredient : this.repo.findAll()) {
			dtos.add(this.mapToDTO(ingredient));
		}
		return dtos;
	}



	public IngredientDTO update(String newName, String name) {

		Ingredient toUpdate = this.repo.findByName(name);
		toUpdate.setName(newName);
		
		Ingredient updated = this.repo.save(toUpdate);

		return this.mapToDTO(updated);


	}



	public List<IngredientDTO> createMulti(List<String> names, Long id) {
		Recipe newRec = this.rRepo.findById(id).orElseThrow(() -> new RecipeNotFoundException());
		return names.stream().map(name -> {
			if (this.repo.existsByName(name)) {
				return this.repo.findByName(name);
			}
			Ingredient newIng = new Ingredient();
			newIng.setName(name);
			newIng.getRecipes().add(newRec);
			return newIng;
		}).map(ingredient -> this.repo.save(ingredient)).map(ingredient -> this.mapToDTO(ingredient))
				.collect(Collectors.toList());
	}


	@Transactional
	public boolean delete(String name) {
		if (!this.repo.existsByName(name)) {
			throw new IngredientNotFoundException();
			}
		this.repo.deleteByName(name);
		return this.repo.existsByName(name);
	}



}
