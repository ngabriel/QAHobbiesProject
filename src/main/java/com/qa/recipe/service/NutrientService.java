package com.qa.recipe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.recipe.exceptions.NutrientNotFoundException;
import com.qa.recipe.persistence.domain.Nutrient;
import com.qa.recipe.persistence.repo.NutrientRepo;

@Service
public class NutrientService {
	private NutrientRepo repo;

	public NutrientService(NutrientRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Nutrient create(Nutrient nutrient) {
		return this.repo.save(nutrient);
		
	}
	
	public List<Nutrient> read(){
		return this.repo.findAll();
		
	}
	public Nutrient read(long id){
		return this.repo.findById(id).orElseThrow(() -> new NutrientNotFoundException());
		
	}
	public Nutrient update(Nutrient nutrient, long id) {
		Nutrient toUpdate = this.repo.findById(id).orElseThrow(() -> new NutrientNotFoundException());
		toUpdate.setName(nutrient.getName());
		
		return this.repo.save(toUpdate);
		
		
	}
	
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return this.repo.existsById(id);
	}
	


}
