package recipe.ingredient;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{
	@Query("FROM Ingredient WHERE name = ?1")
	Optional<Ingredient> findByName(String name);
	
	@Modifying
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Query("Delete FROM Ingredient WHERE name = ?1")
	void deleteByName(@Param("name") String name);
	
	/*
	@Query(value = "Select name From Ingredient where name = :name")
	Ingredient findByName(String name);
	*/
}
