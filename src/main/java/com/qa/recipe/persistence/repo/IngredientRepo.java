package com.qa.recipe.persistence.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.recipe.persistence.domain.Ingredient;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
	List<Ingredient> findIngredientByName(String name);

}
