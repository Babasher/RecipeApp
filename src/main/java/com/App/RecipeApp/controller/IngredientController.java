package com.App.RecipeApp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.RecipeApp.entity.Ingredient;
import com.App.RecipeApp.service.IngredientService;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
	private IngredientService ingredientService;
	
	public IngredientController(IngredientService ingredientService) {
		super();
		this.ingredientService = ingredientService;
	}
	
	//build create REST API
	@PostMapping()
	public ResponseEntity<Ingredient> saveIngredient(@RequestBody Ingredient ingredient) {
		return new ResponseEntity<Ingredient>(ingredientService.saveIngredient(ingredient), HttpStatus.CREATED);
		
	}
	
	//build create REST API
	@GetMapping
	public List<Ingredient> getAllIngredients() {
		return ingredientService.getAllIngredients();
	}
}
