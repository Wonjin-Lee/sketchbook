package io.wonjin.jpa.repository.user.test;

import io.wonjin.jpa.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphaTestUserRepository extends CrudRepository<User, Long> {

}
