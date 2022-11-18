package io.ader.sketchbook.sample.repository.alpha.dev;

import io.ader.sketchbook.sample.domain.alpha.AlphaUser;
import io.ader.sketchbook.sample.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphaUserDevRepository extends CommonRepository<AlphaUser, Long> {

}
