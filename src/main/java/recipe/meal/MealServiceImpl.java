package recipe.meal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	
	@Override
	public void initialMealNutritionSave(Meal meal) {
		List<Double> nutrition = getNutrition(meal);
		meal.setCalories(nutrition.get(0));
		meal.setFats(nutrition.get(1));
		meal.setProteins(nutrition.get(2));
		meal.setCarbs(nutrition.get(3));
	}
	
	private List<Double> getNutrition(Meal meal) {
		
		List<Double> result = new ArrayList<>();
		for(Ingredient i : meal.getIngredients()) {
			result.add(i.getCalories() * i.getUserPortionSize());
			result.add(i.getFats() * i.getFats());
			result.add(i.getProteins() * i.getProteins());
			result.add(i.getCarbs() * i.getCarbs());
		}
		
		return result;
	}

	@Override
	public void deleteByName(String name) {
		mealRepository.findByName(name).orElseThrow(() -> 
		new ResourceNotFoundException("Ingredient", "Name", name));
	
		mealRepository.deleteByName(name);
	}



}
