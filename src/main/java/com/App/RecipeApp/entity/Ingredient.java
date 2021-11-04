package com.App.RecipeApp.entity;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int calories;
	private double fats;
	private double proteins;
	private int carbs;
	private int caloriesPerGram;
	
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public double getFats() {
		return fats;
	}
	public void setFats(double fats) {
		this.fats = fats;
	}
	public double getProteins() {
		return proteins;
	}
	public void setProteins(double proteins) {
		this.proteins = proteins;
	}
	public int getCarbs() {
		return carbs;
	}
	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}
	public int getCaloriesPerGram() {
		return caloriesPerGram;
	}
	public void setCaloriesPerGram(int caloriesPerGram) {
		this.caloriesPerGram = caloriesPerGram;
	}
	
	
	
	
}
