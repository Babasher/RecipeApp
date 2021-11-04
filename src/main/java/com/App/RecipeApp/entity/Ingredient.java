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
	private String name;
	
	private int caloriesPerGram;
	private double fatsPerGram;
	private double proteinsPerGram;
	private int carbsPerGram;
	
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
	public int getCaloriesPerGram() {
		return caloriesPerGram;
	}
	public void setCaloriesPerGram(int caloriesPerGram) {
		this.caloriesPerGram = caloriesPerGram;
	}
	public double getFatsPerGram() {
		return fatsPerGram;
	}
	public void setFatsPerGram(double fatsPerGram) {
		this.fatsPerGram = fatsPerGram;
	}
	public double getProteinsPerGram() {
		return proteinsPerGram;
	}
	public void setProteinsPerGram(double proteinsPerGram) {
		this.proteinsPerGram = proteinsPerGram;
	}
	public int getCarbsPerGram() {
		return carbsPerGram;
	}
	public void setCarbsPerGram(int carbsPerGram) {
		this.carbsPerGram = carbsPerGram;
	}
		
}
