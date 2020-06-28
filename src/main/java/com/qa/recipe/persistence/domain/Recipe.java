package com.qa.recipe.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "recipe_name", unique = true)
	@NotNull
	@Size(min = 0, max = 80)
	private String name;
	
	@Column(name = "recipe_method", unique = true)
	@NotNull
	private String method;
	
	@ManyToMany(targetEntity = Ingredient.class)
	private Ingredient ingredient;
	
	public Recipe() {
		
	}

	public Recipe(String name, String method) {
		super();
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

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	
	
	
	

}
