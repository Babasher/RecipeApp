package recipe.meal;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface MealService {
	Meal saveMeal(Meal meal);
	void initialMealNutritionSave(Meal meal);
	List<Meal> findAll();
	Meal getMealByName(String name);
	void deleteByName(@Param("name") String name);
}
