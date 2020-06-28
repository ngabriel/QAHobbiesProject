package com.qa.recipe.persistence.repo;
import com.qa.recipe.persistence.domain.Ingredient;
import com.qa.recipe.persistence.domain.Recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {
	List<Recipe> findRecipebyIngredient(Ingredient ingredient);

}
