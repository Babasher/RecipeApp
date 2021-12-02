package recipe.meal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import recipe.ingredient.Ingredient;

@Entity
@Table(name = "meal")
public class Meal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	private double calories;
	private double fats;
	private double proteins;
	private double carbs;
	private String portion;
	
	@OneToMany(targetEntity = Ingredient.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "ing_fk", referencedColumnName = "id")
	private List<Ingredient> ingredients = new ArrayList<>();

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

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
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
	public String getPortion() {
		return portion;
	}
	public void setPortion(String portion) {
		this.portion = portion;
	}
	
	
}
