package io.ader.sketchbook.core.repository.amazon.dev;

import io.ader.sketchbook.core.domain.entity.amazon.User;
import io.ader.sketchbook.core.repository.amazon.AmazonRepository;
import org.springframework.stereotype.Repository;

@Repository("AmazonDevUserRepo")
public interface UserDevRepository extends AmazonRepository<User, Long> {

}
