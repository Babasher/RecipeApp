package recipe.meal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import recipe.exception.ResourceNotFoundException;
import recipe.ingredient.Ingredient;
import recipe.meal.math.NutritionParser;

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
		meal.setPortion(nutrition.get(4) + " grams");
	}
	
	private List<Double> getNutrition(Meal meal) {
		List<Double> result = new ArrayList<>();
		
		NutritionParser parser = new NutritionParser();
		
		double calories = 0;
		double fats = 0;
		double proteins = 0;
		double carbs = 0;
		double grams = 0;
		
		for(Ingredient i : meal.getIngredients()) {
			double userPortion = i.getUserPortionSize();
			double singleServingSize = (double) parser.parseSingleServingSize(i.getSingleServingSize());
			
			calories += userPortion * i.getCalories();
			fats += userPortion * i.getFats();
			proteins += userPortion * i.getProteins();
			carbs += userPortion * i.getCarbs();
			grams += userPortion * singleServingSize;
			
		}
		
		result.add(calories); //0 
		result.add(fats); //1
		result.add(proteins); //2
		result.add(carbs); //3 
		result.add(grams); //4
		
		return result;
	}

	@Override
	public void deleteByName(String name) {
		mealRepository.findByName(name).orElseThrow(() -> 
		new ResourceNotFoundException("Ingredient", "Name", name));
	
		mealRepository.deleteByName(name);
	}



}
