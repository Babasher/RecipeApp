package recipe.ingredient;

import java.util.List;

public interface IngredientService {
	Ingredient saveIngredient(Ingredient ingredient);
	List<Ingredient> getAllIngredients();
	Ingredient getIngredientByName(String name);
	Ingredient updateIngredient(Ingredient ingredient, String name);
	void deleteIngredientByName(String name);
	
}
