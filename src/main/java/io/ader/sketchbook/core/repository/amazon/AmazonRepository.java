package io.ader.sketchbook.core.repository.amazon;

import io.ader.sketchbook.core.repository.CommonRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AmazonRepository<T, ID> extends CommonRepository<T, ID> {

}
