package recipe.meal;

import java.util.List;

public interface MealService {
	Meal saveMeal(Meal meal);
	void updateNutrition(Meal meal);
	List<Meal> findAll();
	Meal getMealByName(String name);
}
