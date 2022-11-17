package io.ader.sketchbook.repository.beta.dev;

import io.ader.sketchbook.domain.beta.BetaUser;
import io.ader.sketchbook.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetaUserDevRepository extends CommonRepository<BetaUser, Long> {

}
