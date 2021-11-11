package recipe.ingredient;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
	private IngredientService ingredientService;
	
	public IngredientController(IngredientService ingredientService) {
		super();
		this.ingredientService = ingredientService;
	}
	
	//build create REST API
	@PostMapping()
	public ResponseEntity<Ingredient> saveIngredient(@RequestBody Ingredient ingredient) {
		return new ResponseEntity<Ingredient>(ingredientService.saveIngredient(ingredient), HttpStatus.CREATED);
		
	}
	
	//build create REST API
	@GetMapping
	public List<Ingredient> getAllIngredients() {
		return ingredientService.getAllIngredients();
	}
	
	//build create REST API
	@GetMapping("{name}")
	public ResponseEntity<Ingredient> getIngredientByName(@PathVariable("name") String name) {
		return new ResponseEntity<Ingredient>(ingredientService.getIngredientByName(name), HttpStatus.OK);
	}
	
	//build create REST API
	@PutMapping("{name}")
	public ResponseEntity<Ingredient> updateIngredient(@PathVariable("name") String name, 
														@RequestBody Ingredient ingredient) {
		return new ResponseEntity<Ingredient>(ingredientService.updateIngredient(ingredient, name), HttpStatus.OK);
		
	}
}
