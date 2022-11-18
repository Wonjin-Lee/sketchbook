package io.ader.sketchbook.sample.repository.beta.dev;

import io.ader.sketchbook.sample.domain.beta.BetaUser;
import io.ader.sketchbook.sample.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetaUserDevRepository extends CommonRepository<BetaUser, Long> {

}
