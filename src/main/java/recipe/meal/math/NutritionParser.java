package recipe.meal.math;

import recipe.meal.Meal;

public class NutritionParser {
	public Object parseSingleServingSize(String singleServingSize) {
		String lettersRemoved = singleServingSize.replaceAll("[^\\d.]", "");
		Integer value = Integer.parseInt(lettersRemoved);
		return (double) value;
	}
}
