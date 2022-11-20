package io.ader.sketchbook.core.repository.facebook.dev;

import io.ader.sketchbook.core.domain.entity.facebook.User;
import io.ader.sketchbook.core.repository.facebook.FacebookRepository;
import org.springframework.stereotype.Repository;

@Repository("FacebookDevUserRepo")
public interface UserDevRepository extends FacebookRepository<User, Long> {

}
