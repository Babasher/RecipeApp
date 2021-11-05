package com.App.RecipeApp.service;

import java.util.List;

import com.App.RecipeApp.entity.Ingredient;

public interface IngredientService {
	Ingredient saveIngredient(Ingredient ingredient);
	List<Ingredient> getAllIngredients();
	Ingredient getIngredientByName(String name);
}
