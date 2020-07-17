package com.qa.recipe.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private List<Recipe> recipes = new ArrayList<>();

//	@ManyToMany()
//	private List <Nutrient> nutrient;
//
//
//	public List<Nutrient> getNutrient.() {
//		return nutrient;
//	}
//
//
//	public void setNutrient(List<Nutrient> nutrient) {
//		this.nutrient = nutrient;
//	}

	public Ingredient(String name) {
		super();
		this.name = name;

	}

	public Ingredient(Long id, @NotNull @Size(min = 0, max = 80) String name) {
		super();
		this.id = id;
		this.name = name;
		// this.nutrient = nutrient;
	}

	public Ingredient() {
		// TODO Auto-generated constructor stub
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

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", recipes=" + recipes + "]";
	}

}
