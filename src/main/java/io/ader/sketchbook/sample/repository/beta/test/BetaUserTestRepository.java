package io.ader.sketchbook.sample.repository.beta.test;

import io.ader.sketchbook.sample.domain.beta.BetaUser;
import io.ader.sketchbook.sample.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetaUserTestRepository extends CommonRepository<BetaUser, Long> {

}
