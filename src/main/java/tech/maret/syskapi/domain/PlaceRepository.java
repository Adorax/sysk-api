/**
 * 
 */
package tech.maret.syskapi.domain;

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

}