package recipe.meal;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface MealRepository extends JpaRepository<Meal, Integer>{
	Optional<Meal> findByName(String name);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Query("Delete FROM Meal WHERE name = ?1")
	void deleteByName(String name);
}
