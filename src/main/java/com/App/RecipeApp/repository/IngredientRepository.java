package com.App.RecipeApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.App.RecipeApp.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{
	@Query("FROM Ingredient WHERE name = ?1")
	Optional<Ingredient> findByName(String name);
	
	/*
	@Query(value = "Select name From Ingredient where name = :name")
	Ingredient findByName(String name);
	*/
}
