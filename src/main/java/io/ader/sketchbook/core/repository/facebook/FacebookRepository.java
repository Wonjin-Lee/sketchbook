package io.ader.sketchbook.core.repository.facebook;

import io.ader.sketchbook.core.repository.CommonRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FacebookRepository<T, ID> extends CommonRepository<T, ID> {

}
