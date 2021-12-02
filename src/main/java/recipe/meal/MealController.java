package recipe.meal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/meals")
public class MealController {
	@Autowired
	private MealService mealService;
	
	@PostMapping()
	public ResponseEntity<Meal> saveMeal(@RequestBody Meal meal) {
		return new ResponseEntity<Meal>(mealService.saveMeal(meal), HttpStatus.CREATED); 
	}
	
	@GetMapping("/findAllOrders")
	public List<Meal> findAllMeals() {
		return mealService.findAll();
	}
	
	@GetMapping("{name}")
	public ResponseEntity<Meal> getMealByName(@PathVariable("name") String name) {
		return new ResponseEntity<Meal>(mealService.getMealByName(name), HttpStatus.OK);
	}
	
}
