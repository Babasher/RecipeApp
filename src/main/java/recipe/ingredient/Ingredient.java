package recipe.ingredient;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
	@Id
	private int id;
	private String name;
	
	private double calories;
	private double fats;
	private double proteins;
	private double carbs;
	private String singleServingSize;
	private double userPortionSize;

	
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
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
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
	public double getCarbs() {
		return carbs;
	}
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	public String getSingleServingSize() {
		return singleServingSize;
	}
	public void setSingleServingSize(String singleServingSize) {
		this.singleServingSize = singleServingSize;
	}
	public double getUserPortionSize() {
		return userPortionSize;
	}
	public void setUserPortionSize(int userPortionSize) {
		this.userPortionSize = userPortionSize;
	}
	

}
