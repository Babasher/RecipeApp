package recipe.ingredient;

import java.util.List;
import org.springframework.stereotype.Service;
import recipe.exception.*;

@Service
public class IngredientServiceImpl implements IngredientService{
	
	IngredientRepository ingredientRepository;
	
	public IngredientServiceImpl(IngredientRepository ingredientRepository) {
		super();
		this.ingredientRepository = ingredientRepository;
	}

	@Override
	public Ingredient saveIngredient(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		return ingredientRepository.findAll();
	}

	@Override
	public Ingredient getIngredientByName(String name) {
		//Optional<Ingredient> ingredient = (Optional<Ingredient>) ingredientRepository.findByName(name);
	
		/*
		if(ingredient.isPresent()) {
			return ingredient.get();
		} else {
			throw new ResourceNotFoundException("Food", "Name", name);
		}
		*/
		
		return ingredientRepository.findByName(name).orElseThrow(() -> 
			new ResourceNotFoundException("Ingredient", "Name", name));
		
	}

	@Override
	public Ingredient updateIngredient(Ingredient ingredient, String name) {
		Ingredient existingIngredient = ingredientRepository.findByName(name).orElseThrow(() -> 
				new ResourceNotFoundException("Ingredient", "Name", name));
		
		existingIngredient.setCalories(ingredient.getCalories());
		existingIngredient.setCarbs(ingredient.getCarbs());
		existingIngredient.setFats(ingredient.getFats());
		existingIngredient.setProteins(ingredient.getProteins());
		existingIngredient.setName(ingredient.getName());
		existingIngredient.setSingleServingSize(ingredient.getSingleServingSize());
		
		ingredientRepository.save(existingIngredient);
		
		return null;
	}

	@Override
	public void deleteIngredientByName(String name) {
		ingredientRepository.findByName(name).orElseThrow(() -> 
			new ResourceNotFoundException("Ingredient", "Name", name));
		
		ingredientRepository.deleteByName(name);
		
		
		
	}	


}
