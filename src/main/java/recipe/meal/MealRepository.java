package recipe.meal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer>{
	Optional<Meal> findByName(String name);
}
