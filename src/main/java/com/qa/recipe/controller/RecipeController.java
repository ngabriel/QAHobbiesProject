package com.qa.recipe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.recipe.persistence.domain.Recipe;
import com.qa.recipe.service.RecipeService;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

	private RecipeService service;

	public RecipeController(RecipeService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public Recipe creaat(@RequestBody Recipe recipe) {
		return this.service.create(recipe);
	}

	@GetMapping("/read")
	public List<Recipe> read() {
		return this.service.read();

	}

	@PutMapping("/update/{id}")
	public Recipe update(@PathVariable Long id, @RequestBody Recipe recipe) {
		return this.service.update(recipe, id);

	}

	@DeleteMapping("/delete{id}")
	public boolean delete(@PathVariable Long id) {
		return this.service.delete(id);
	}

}
