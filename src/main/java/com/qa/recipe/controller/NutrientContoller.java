//package com.qa.recipe.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.qa.recipe.persistence.domain.Nutrient;
//import com.qa.recipe.service.NutrientService;
//
//@RestController
//@RequestMapping("/nutrient")
//public class NutrientContoller {
//	
//	private NutrientService service;
//
//	//@Autowired
//	public NutrientContoller(NutrientService service) {
//		super();
//		this.service = service;
//	}
//	@PostMapping("/create")
//	public Nutrient create(@RequestBody Nutrient nutrient) {
//		return this.service.create(nutrient);
//	}
//	
//	@GetMapping("/read")
//	public List<Nutrient> read(){
//		return this.service.read();
//		
//	}
//	
//	@PutMapping("/update/{id}")
//	public Nutrient update(@PathVariable Long id, @RequestBody Nutrient nutrient) {
//		return this.service.update(nutrient, id);
//		
//	}
//	
//	@DeleteMapping("/delete{id}")
//	public boolean delete(@PathVariable Long id) {
//		return this.service.delete(id);
//	}
//	
//	
//
//}
