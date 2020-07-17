package com.qa.recipe.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
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

	
	@PutMapping("/update/{name}")
	public ResponseEntity<IngredientDTO> update(@PathVariable String name, @RequestParam("name") String newName) {
		return new ResponseEntity<IngredientDTO>(this.service.update(newName, name), HttpStatus.ACCEPTED);

	}


	
	@PostMapping("/createRecipe/{id}")
	public ResponseEntity<List<IngredientDTO>> update(@PathVariable Long id, @RequestBody List<String> names) {
		return new ResponseEntity<List<IngredientDTO>>(this.service.createMulti(names, id), HttpStatus.ACCEPTED);

	}
	
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<?> delete(@PathVariable String name) {
		return this.service.delete(name) ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
				: new ResponseEntity<String>("DELETED", HttpStatus.NO_CONTENT);
	}

}
