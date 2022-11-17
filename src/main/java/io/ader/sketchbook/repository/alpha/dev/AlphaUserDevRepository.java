package io.ader.sketchbook.repository.alpha.dev;

import io.ader.sketchbook.domain.alpha.AlphaUser;
import io.ader.sketchbook.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphaUserDevRepository extends CommonRepository<AlphaUser, Long> {

}
