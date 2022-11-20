package io.ader.sketchbook.core.repository.amazon.test;

import io.ader.sketchbook.core.domain.entity.amazon.User;
import io.ader.sketchbook.core.repository.amazon.AmazonRepository;
import org.springframework.stereotype.Repository;

@Repository("AmazonTestUserRepo")
public interface UserTestRepository extends AmazonRepository<User, Long> {

}
