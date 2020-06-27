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
	
	@Column(name = "recipe_name", unique = true)
	@NotNull
	private String method;
	
//	@ManyToMany(targetEntity = Ingredient.class)
//	private Ingredient ingredient;
	
	
	
	

}
