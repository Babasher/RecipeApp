package recipe.meal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import recipe.exception.ResourceNotFoundException;
import recipe.ingredient.Ingredient;

@Service
public class MealServiceImpl implements MealService{
	MealRepository mealRepository;

	public MealServiceImpl(MealRepository mealRepository) {
		super();
		this.mealRepository = mealRepository;
	}

	@Override
	public Meal saveMeal(Meal meal) {
		return mealRepository.save(meal);
	}

	@Override
	public List<Meal> findAll() {
		return mealRepository.findAll();
	}

	@Override
	public Meal getMealByName(String name) {
		List<Double> nutrition = getNutrition(mealRepository.findByName(name).get());
		
		System.out.println(nutrition);
		
		return mealRepository.findByName(name).orElseThrow(() -> 
			new ResourceNotFoundException("Meal", "Name", name));
	}
	
	private List<Double> getNutrition(Meal meal) {
		List<Double> results = new ArrayList<>();
		double calories = 0;
		double fats = 0;
		double proteins = 0;
		double carbs = 0;
		
		for(Ingredient i : meal.getIngredients()) {
			calories += i.getCalories();
			fats += i.getFats();
			proteins += i.getProteins();
			carbs += i.getCarbs();
		}
		
		results.add(calories);
		results.add(fats);
		results.add(proteins);
		results.add(carbs);
		
		return results;
	}

}
