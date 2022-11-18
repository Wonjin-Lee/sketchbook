package io.ader.sketchbook.sample.repository.alpha.test;

import io.ader.sketchbook.sample.domain.alpha.AlphaUser;
import io.ader.sketchbook.sample.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphaUserTestRepository extends CommonRepository<AlphaUser, Long> {

}
