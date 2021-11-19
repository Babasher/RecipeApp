package recipe.meal;

import java.util.List;

public interface MealService {
	Meal saveMeal(Meal meal);
	List<Meal> findAll();
}
