package io.ader.sketchbook.repository.beta.test;

import io.ader.sketchbook.domain.beta.BetaUser;
import io.ader.sketchbook.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetaUserTestRepository extends CommonRepository<BetaUser, Long> {

}
