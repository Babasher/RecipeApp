package com.App.RecipeApp.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.App.RecipeApp.entity.Ingredient;
import com.App.RecipeApp.exception.ResourceNotFoundException;
import com.App.RecipeApp.repository.IngredientRepository;
import com.App.RecipeApp.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService{
	
	IngredientRepository ingredientRepository;
	
	public IngredientServiceImpl(IngredientRepository ingredientRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
	}

	@Override
	public Ingredient saveIngredient(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		return ingredientRepository.findAll();
	}

	@Override
	public Ingredient getIngredientByName(String name) {
		//Optional<Ingredient> ingredient = (Optional<Ingredient>) ingredientRepository.findByName(name);
	
		/*
		if(ingredient.isPresent()) {
			return ingredient.get();
		} else {
			throw new ResourceNotFoundException("Food", "Name", name);
		}
		*/
		
		return ingredientRepository.findByName(name).orElseThrow(() -> 
			new ResourceNotFoundException("Ingredient", "Name", name));
		
	}

	@Override
	public Ingredient updateIngredient(Ingredient ingredient, String name) {
		Ingredient existingIngredient = ingredientRepository.findByName(name).orElseThrow(() -> 
				new ResourceNotFoundException("Ingredient", "Name", name));
		
		existingIngredient.setCalories(ingredient.getCalories());
		existingIngredient.setCarbs(ingredient.getCarbs());
		existingIngredient.setFats(ingredient.getFats());
		existingIngredient.setProteins(ingredient.getProteins());
		existingIngredient.setName(ingredient.getName());
		
		ingredientRepository.save(existingIngredient);
		
		return null;
	}


}
