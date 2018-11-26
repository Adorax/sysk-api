package tech.maret.syskapi.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByCategoryName(@Param("categoryName") String categoryName);

	
	@Query("SELECT DISTINCT(c.categoryName) FROM Category c\n" + 
			"JOIN PlaceCategory pc ON c.idCategory = pc.category\n" + 
			"JOIN Place p ON pc.place = p.idPlace\n" + 
			"JOIN City ci ON p.city = ci.idCity\n" + 
			"WHERE ci.nameCity=:city")
	String[] findCat(@Param("city") String city);
	
	@Query("SELECT p FROM Place p\n" + 
			"JOIN City ci ON p.city = ci.idCity\n" + 
			"JOIN PlaceCategory pc ON p.idPlace = pc.place\n" + 
			"JOIN Category c ON c.idCategory = pc.category\n" + 
			"WHERE ci.nameCity=:city AND c.categoryName=:category")
	List<Place> findPlaces(@Param("city") String city, @Param("category") String category);
	
}