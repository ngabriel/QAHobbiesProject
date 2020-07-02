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

import com.qa.recipe.persistence.domain.Ingredient;
import com.qa.recipe.service.IngredientService;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

	private IngredientService service;

	public IngredientController(IngredientService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public Ingredient creaat(@RequestBody Ingredient ingredient) {
		return this.service.create(ingredient);
	}

	@GetMapping("/read")
	public List<Ingredient> read() {
		return this.service.read();

	}

	@PutMapping("/update/{id}")
	public Ingredient update(@PathVariable Long id, @RequestBody Ingredient ingredient) {
		return this.service.update(ingredient, id);

	}

	@DeleteMapping("/delete{id}")
	public boolean delete(@PathVariable Long id) {
		return this.service.delete(id);
	}

}
