package com.App.RecipeApp.service.implementation;

import org.springframework.stereotype.Service;

import com.App.RecipeApp.entity.Ingredient;
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

}
