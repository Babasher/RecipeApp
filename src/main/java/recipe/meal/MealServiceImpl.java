package recipe.meal;

import java.util.List;

import org.springframework.stereotype.Service;

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
}
