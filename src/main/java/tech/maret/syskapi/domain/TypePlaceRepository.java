package tech.maret.syskapi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TypePlaceRepository extends CrudRepository<TypePlace, Long> {
	List<TypePlace> findByTypePlaceName(@Param("typePlaceName") String typePlaceName);

}