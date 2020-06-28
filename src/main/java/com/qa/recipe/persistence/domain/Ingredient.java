package com.qa.recipe.persistence.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "ingredient")
public class Ingredient {


	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "ingredient_name", unique = true)
	@NotNull
	@Size(min = 0, max = 80)
	private String name;
	
	@ManyToMany(mappedBy = "ingredient")
	private List<Recipe> recipes;
	
	@ManyToOne(targetEntity = Ingredient.class)
	private Nutrient nutrient;


	public Ingredient() {
		
	}


	public Ingredient(Long id, @NotNull @Size(min = 0, max = 80) String name) {
		super();
		this.id = id;
		this.name = name;
		//this.nutrient = nutrient;
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


//	public Nutrient getNutrient() {
//		return nutrient;
//	}
//
//
//	public void setNutrient(Nutrient nutrient) {
//		this.nutrient = nutrient;
//	}


}
