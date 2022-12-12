package io.wonjin.jpa.repository.user.dev;

import io.wonjin.jpa.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphaDevUserRepository extends CrudRepository<User, Long> {

}
