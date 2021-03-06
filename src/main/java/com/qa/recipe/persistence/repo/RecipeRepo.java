package com.qa.recipe.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.recipe.persistence.domain.Ingredient;
import com.qa.recipe.persistence.domain.Recipe;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {
	List<Recipe> findByIngredient(Ingredient ingredient);
	Recipe findByName(String name);
	boolean existsByName(String name);
	void deleteByName(String name);
}
