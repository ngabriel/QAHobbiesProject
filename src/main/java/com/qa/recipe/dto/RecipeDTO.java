package com.qa.recipe.dto;

import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {

	private Long id;
	

	private String name;

	private String method;
	

	private List<IngredientDTO> ingredients = new ArrayList<>();
	
	public RecipeDTO() {

	}

	public RecipeDTO(String name, String method, Long id) {
		this.id = id;
		this.name = name;
		this.method = method;
		//this.ingredient = ingredient;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<IngredientDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredient(List<IngredientDTO> ingredients) {
		this.ingredients = ingredients;
	}


	@Override
	public String toString() {
		return "RecipeDTO [id=" + id + ", name=" + name  + ", method=" + method  + "]";
	}
	
	
	

}

