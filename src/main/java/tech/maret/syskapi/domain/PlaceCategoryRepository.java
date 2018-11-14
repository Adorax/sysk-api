package tech.maret.syskapi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlaceCategoryRepository extends CrudRepository<PlaceCategory, Long> {
	List<PlaceCategory> findByPlace(@Param("place") String place);
	List<PlaceCategory> findByCategory(@Param("category") String category);
}