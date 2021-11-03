package com.App.RecipeApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private float calories;
	private float proteins;
	private float carbs;
	private float fats;
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
	public float getCalories() {
		return calories;
	}
	public void setCalories(float calories) {
		this.calories = calories;
	}
	public float getProteins() {
		return proteins;
	}
	public void setProteins(float proteins) {
		this.proteins = proteins;
	}
	public float getCarbs() {
		return carbs;
	}
	public void setCarbs(float carbs) {
		this.carbs = carbs;
	}
	public float getFats() {
		return fats;
	}
	public void setFats(float fats) {
		this.fats = fats;
	}
	
	
}
