package com.qa.recipe.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.recipe.dto.IngredientDTO;
import com.qa.recipe.dto.RecipeDTO;
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
	public ResponseEntity<IngredientDTO> create(@RequestBody Ingredient ingredient) {
		return new ResponseEntity<IngredientDTO>(this.service.create(ingredient), HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<IngredientDTO>> read() {
		return new ResponseEntity<List<IngredientDTO>>(this.service.read(), HttpStatus.OK);

	}
	@GetMapping("/read/{id}")
	public ResponseEntity<IngredientDTO> readOne(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.read(id));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<IngredientDTO> update(@PathVariable Long id, @RequestBody Ingredient ingredient) {
		return new ResponseEntity<IngredientDTO>(this.service.update(ingredient, id), HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/delete{id}")
	public boolean delete(@PathVariable Long id) {
		return this.service.delete(id);
	}

}
