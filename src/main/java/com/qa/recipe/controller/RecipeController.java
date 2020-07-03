package com.qa.recipe.controller;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.recipe.dto.RecipeDTO;
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
	public ResponseEntity<RecipeDTO> create(@RequestBody Recipe recipe) {
		return new ResponseEntity<RecipeDTO>(this.service.create(recipe), org.springframework.http.HttpStatus.CREATED);
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<RecipeDTO> readOne(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.read(id));
	}

	@GetMapping("/read")
	public ResponseEntity<List<RecipeDTO>> read() {
		return new ResponseEntity<List<RecipeDTO>>(this.service.read(), org.springframework.http.HttpStatus.OK);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<RecipeDTO> update(@PathVariable Long id, @RequestBody Recipe recipe) {
		return new ResponseEntity<RecipeDTO>(this.service.update(recipe, id), org.springframework.http.HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/delete{id}")
	public boolean delete(@PathVariable Long id) {
		return this.service.delete(id);
	}

}
