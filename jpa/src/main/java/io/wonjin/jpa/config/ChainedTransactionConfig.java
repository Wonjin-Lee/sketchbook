package io.wonjin.jpa.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ChainedTransactionConfig {
    @Bean
    public PlatformTransactionManager chainedTransactionManager(
            @Qualifier("transactionManager") PlatformTransactionManager first,
            @Qualifier("sketchbookAlphaDevTransactionManager") PlatformTransactionManager second,
            @Qualifier("sketchbookAlphaTestTransactionManager") PlatformTransactionManager third
    ) {
        return new ChainedTransactionManager(first, second, third);
    }
}
