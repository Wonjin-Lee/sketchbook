package io.ader.sketchbook.core.repository.amazon.dev;

import io.ader.sketchbook.core.domain.entity.amazon.Cart;
import io.ader.sketchbook.core.repository.amazon.AmazonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDevRepository extends AmazonRepository<Cart, Long> {

}
