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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.recipe.dto.IngredientDTO;
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

	@PutMapping("/updateName/{name}")
	public ResponseEntity<RecipeDTO> updateName(@PathVariable String name, @RequestParam("name") String newName) {
		return new ResponseEntity<RecipeDTO>(this.service.updateName(newName, name),  org.springframework.http.HttpStatus.OK);

	}
	@PutMapping("/updateMethod/{method}")
	public ResponseEntity<RecipeDTO> updateMethod(@PathVariable String method, @RequestParam("method") String newMethod, String name) {
		return new ResponseEntity<RecipeDTO>(this.service.updateMethod(newMethod, method, name),  org.springframework.http.HttpStatus.OK);

	}

	@DeleteMapping("/delete/{name}")
	public boolean delete(@PathVariable String name) {
		return this.service.delete(name);
	}

}
