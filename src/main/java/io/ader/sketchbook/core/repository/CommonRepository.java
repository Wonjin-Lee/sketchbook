package io.ader.sketchbook.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<T, ID> extends CrudRepository<T, ID> {

}
