package io.ader.sketchbook.repository.alpha.test;

import io.ader.sketchbook.domain.alpha.AlphaUser;
import io.ader.sketchbook.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlphaUserTestRepository extends CommonRepository<AlphaUser, Long> {

}
