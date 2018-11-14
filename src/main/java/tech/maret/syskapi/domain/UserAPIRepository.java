package tech.maret.syskapi.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


public interface UserAPIRepository extends CrudRepository<UserAPI, Long> {
	UserAPI findByUsername(@Param("username") String username);

}

