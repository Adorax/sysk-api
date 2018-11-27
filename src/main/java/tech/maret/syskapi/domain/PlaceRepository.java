/**
 * 
 */
package tech.maret.syskapi.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


/**
 * @author maret
 *
 */
@RepositoryRestResource
public interface PlaceRepository extends CrudRepository<Place, Long> {
	List<Place> findByNamePlace(@Param("namePlace") String namePlace);
	
	@Query("SELECT p FROM Place p\n" + 
			"JOIN City ci ON p.city = ci.idCity\n" + 
			"JOIN PlaceCategory pc ON p.idPlace = pc.place\n" + 
			"JOIN Category c ON c.idCategory = pc.category\n" + 
			"WHERE ci.nameCity=:city AND c.categoryName=:category")
	List<Place> findPlaces(@Param("city") String city, @Param("category") String category);
}