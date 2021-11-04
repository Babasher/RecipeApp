package com.App.RecipeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.RecipeApp.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

}
