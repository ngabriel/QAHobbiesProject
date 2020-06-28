package com.qa.recipe.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.recipe.persistence.domain.Nutrient;

public interface NutrientRepo extends JpaRepository<Nutrient, Long> {

	List<Nutrient> findByName(String name);
}
