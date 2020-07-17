package com.qa.recipe.persistence.repo;
import java.util.List;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.recipe.persistence.domain.Ingredient;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient, Long> {
	//Ingredient findById(long id);
	Ingredient findByName(String name);
	boolean existsByName(String name);
	void deleteByName(String name);
}
