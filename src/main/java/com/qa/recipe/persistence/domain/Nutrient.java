//package com.qa.recipe.persistence.domain;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
////@Entity
//public class Nutrient {
//	
//	@Id
//	@GeneratedValue
//	private Long id;
//	
//	@Column(name = "nutrient_name", unique = true)
//	@NotNull
//	@Size(min = 0, max = 80)
//	private String name;
//	
//	@ManyToMany()
//	private List<Ingredient> ingredients;
//
//	public List<Ingredient> getIngredients() {
//		return ingredients;
//	}
//	public void setIngredients(List<Ingredient> ingredients) {
//		this.ingredients = ingredients;
//	}
//	public Nutrient(String name) {
//
//		this.name = name;
//	}
//	public Nutrient() {
//
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//
//}
