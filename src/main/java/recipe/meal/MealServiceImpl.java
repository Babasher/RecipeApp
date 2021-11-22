package recipe.meal;

import java.util.List;

import org.springframework.stereotype.Service;

import recipe.exception.ResourceNotFoundException;

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
		return mealRepository.findByName(name).orElseThrow(() -> 
		new ResourceNotFoundException("Meal", "Name", name));
	}

}
